// * 썸머노트 실행 (쪽지 보내기 기능은 제거됨)
$(document).ready(function () {
  $('#summernote').summernote({
    height: 300,
    lang: 'ko-KR',
    placeholder: '메시지 내용을 입력해주세요',
  });
});

// 이전 페이지로 돌아가기
const goBack = () => {
  window.history.back();
};

// URL 파라미터 가져오기 함수
const getUrlParams = () => {
  const params = {};
  const queryString = window.location.search.substring(1);
  const paramPairs = queryString.split('&');

  paramPairs.forEach(pair => {
    const [key, value] = pair.split('=');
    if (key && value) {
      params[key] = decodeURIComponent(value);
    }
  });

  return params;
};

// 페이지 로드 시 실행
document.addEventListener('DOMContentLoaded', () => {
  // URL 파라미터 확인
  const params = getUrlParams();

  // 수신자 ID가 있으면 설정
  if (params.receiverId) {
    document.getElementById('receiverId').value = params.receiverId;
  }

  // 원본 제목이 있으면 "Re: " 추가하여 설정
  if (params.originalTitle) {
    document.getElementById('messageTitle').value = `Re: ${params.originalTitle}`;
  }
});

// 메시지 목록 로드 함수
const loadMessages = (type) => {
  currentTab = type;
  // 탭 스타일 업데이트
  document.querySelectorAll('.tab').forEach((tab) => {
    tab.classList.remove('active');
  });
  document.querySelector(`.tab[onclick="loadMessages('${type}')"]`).classList.add('active');

  // API 요청
  fetch(`/api/messages/${type}`)
    .then((response) => response.json())
    .then((data) => {
      const messageList = document.getElementById('messageList');
      let html = '';

      data.forEach((message) => {
        html += `
                    <li class="message-item">
                        <div class="message-checkbox">
                            <input type="checkbox"
                                   id="msg${message.id}"
                                   onclick="toggleMessageSelection(${message.id})" />
                        </div>
                        <div class="message-content" onclick="viewMessageDetail(${message.id})">
                            <div class="message-header">
                                <span class="message-sender">${
                                  type === 'receive' ? message.sender : message.receiver
                                }</span>
                                <span class="message-date">${formatDate(message.sendDate)}</span>
                            </div>
                            <div class="message-title">${message.title}</div>
                            <div class="message-preview">${message.content}</div>
                        </div>
                    </li>
                `;
      });

      messageList.innerHTML = html;
    })
    .catch((error) => {
      console.error('메시지 로드 중 오류 발생:', error);
      alert('메시지를 불러오는데 실패했습니다.');
    });
};

// 메시지 선택 토글 함수
const toggleMessageSelection = (messageId) => {
  if (selectedMessages.has(messageId)) {
    selectedMessages.delete(messageId);
  } else {
    selectedMessages.add(messageId);
  }
};

// 선택된 메시지 삭제 함수
const deleteSelectedMessages = () => {
  if (selectedMessages.size === 0) {
    alert('삭제할 메시지를 선택해주세요.');
    return;
  }

  if (!confirm('선택한 메시지를 삭제하시겠습니까?')) {
    return;
  }

  const messageIds = Array.from(selectedMessages);

  fetch('/api/messages/delete', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      messageIds: messageIds,
      type: currentTab,
    }),
  })
    .then((response) => response.json())
    .then((result) => {
      if (result.success) {
        alert('메시지가 삭제되었습니다.');
        selectedMessages.clear();
        loadMessages(currentTab);
      } else {
        alert('메시지 삭제에 실패했습니다.');
      }
    })
    .catch((error) => {
      console.error('메시지 삭제 중 오류 발생:', error);
      alert('메시지 삭제에 실패했습니다.');
    });
};

// 메시지 상세 보기 함수
const viewMessageDetail = (messageId) => {
  fetch(`/api/messages/detail/${messageId}`)
    .then((response) => response.json())
    .then((message) => {
      // 메시지 상세 내용을 모달로 표시
      const modalHtml = `
                <div class="modal fade" id="messageDetailModal" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">${message.title}</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body">
                                <p><strong>${currentTab === 'receive' ? '보낸 사람' : '받는 사람'}:</strong>
                                   ${currentTab === 'receive' ? message.sender : message.receiver}</p>
                                <p><strong>날짜:</strong> ${formatDate(message.sendDate)}</p>
                                <hr>
                                <div>${message.content}</div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                            </div>
                        </div>
                    </div>
                </div>
            `;

      // 기존 상세 보기 모달이 있다면 제거
      const existingModal = document.getElementById('messageDetailModal');
      if (existingModal) {
        existingModal.remove();
      }

      // 새 모달 추가 및 표시
      document.body.insertAdjacentHTML('beforeend', modalHtml);
      const modal = new bootstrap.Modal(document.getElementById('messageDetailModal'));
      modal.show();
    })
    .catch((error) => {
      console.error('메시지 상세 조회 중 오류 발생:', error);
      alert('메시지 상세 내용을 불러오는데 실패했습니다.');
    });
};

// 날짜 포맷팅 함수
const formatDate = (dateString) => {
  const date = new Date(dateString);
  return date.toLocaleDateString('ko-KR', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
  });
};

// 페이지 로드 시 받은 쪽지함 표시
document.addEventListener('DOMContentLoaded', () => {
  console.log('message.js open');
  loadMessages('receive');
});
