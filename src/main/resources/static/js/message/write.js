// * 썸머노트 실행
$(document).ready(function() {
  $('#summernote').summernote({
    height: 300,
    lang: 'ko-KR',
    placeholder: '메시지 내용을 입력해주세요'
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

// 쪽지 보내기 함수
const sendMessage = () => {
  const receiverId = document.getElementById('receiverId').value;
  const title = document.getElementById('messageTitle').value;
  const content = $('#summernote').summernote('code');

  if (!receiverId || !title || !content) {
    alert('모든 필드를 입력해주세요.');
    return;
  }

  const messageData = {
    receiverId: receiverId,
    title: title,
    content: content
  };

  fetch('/api/messages/send', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(messageData)
  })
  .then(response => response.json())
  .then(result => {
    if (result.success) {
      alert('메시지를 전송했습니다.');
      // 폼 초기화
      document.getElementById('sendMessageForm').reset();
      $('#summernote').summernote('code', '');
      // 메시지 목록 페이지로 이동
      window.location.href = '/messages';
    } else {
      alert(result.message || '메시지 전송에 실패했습니다.');
    }
  })
  .catch(error => {
    console.error('메시지 전송 중 오류 발생:', error);
    alert('메시지 전송에 실패했습니다.');
  });
};