// ================ 유틸리티 함수 ================
// 현재 로그인한 사용자의 mno를 반환하는 함수
const getCurrentUserMno = () => {
  const mno = sessionStorage.getItem("mno");
  console.log(mno);
  if (!mno) {
    console.error("로그인 정보가 없습니다.");
    return null;
  }
  return mno;
};

// XSS 방지를 위한 HTML 이스케이프 함수
const escapeHtml = (unsafe) => {
  if (!unsafe) return "";
  return unsafe
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;")
    .replace(/'/g, "&#039;");
};

// 날짜 포맷팅 함수
const formatDate = (dateString) => {
  if (!dateString) return "";
  const date = new Date(dateString);
  if (isNaN(date.getTime())) return dateString;
  return `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, "0")}-${String(date.getDate()).padStart(
    2,
    "0"
  )}`;
};

// ================ 메시지 로드 함수 ================
// 받은 쪽지 목록 로드
const loadReceivedMessages = (page = 1) => {
  const loginMno = getCurrentUserMno();
  if (!loginMno) {
    alert("로그인이 필요합니다.");
    return;
  }

  const option = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "include",
  };

  fetch(`/message/receive/find.do?receivermno=${loginMno}&page=${page}`, option)
    .then((response) => {
      if (!response.ok) throw new Error(`HTTP 오류: ${response.status}`);
      return response.json();
    })
    .then((response) => {
      const { list, ...pageInfo } = response;
      displayMessages(list, "received");
      if (list.length > 0) {
        printPageNation(pageInfo, loginMno, true);
      }
    })
    .catch((error) => {
      console.error("받은 쪽지 로드 실패:", error);
      alert("쪽지 목록을 불러오는 데 실패했습니다.");
    });
};

// 보낸 쪽지 목록 로드
const loadSentMessages = (page = 1) => {
  const loginMno = getCurrentUserMno();
  if (!loginMno) {
    alert("로그인이 필요합니다.");
    return;
  }

  const option = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "include",
  };

  fetch(`/message/send/find.do?sendermno=${loginMno}&page=${page}`, option)
    .then((response) => {
      if (!response.ok) throw new Error(`HTTP 오류: ${response.status}`);
      return response.json();
    })
    .then((response) => {
      const { list, ...pageInfo } = response;
      displayMessages(list, "sent");
      if (list.length > 0) {
        printPageNation(pageInfo, loginMno, false);
      }
    })
    .catch((error) => {
      console.error("보낸 쪽지 로드 실패:", error);
      alert("쪽지 목록을 불러오는 데 실패했습니다.");
    });
};

// ================ 메시지 표시 함수 ================
// 메시지 목록 표시
const displayMessages = (messages, type) => {
  if (!Array.isArray(messages)) {
    console.error("유효하지 않은 메시지 데이터:", messages);
    return;
  }

  const tbody = document.getElementById(`${type}Messages`);
  const html = messages.map((message) => createMessageRow(message, type)).join("");
  tbody.innerHTML = html;
};

// 메시지 행 생성
const createMessageRow = (message, type) => {
  const isReceived = type === "received";
  const userColumn = isReceived ? message.sendmid : message.receivermid;
  const deleteFunction = isReceived ? "confirmDeleteReceivedMessage" : "confirmDeleteSentMessage";

  return `
        <tr>
            <td>${escapeHtml(message.metitle)}</td>
            <td>${escapeHtml(userColumn)}</td>
            <td>${formatDate(message.medate)}</td>
            <td>
                <button class="btn btn-danger btn-sm"
                        aria-label="삭제"
                        onclick="${deleteFunction}(${message.meno}, ${getCurrentUserMno()})">
                    삭제
                </button>
            </td>
        </tr>
    `;
};

// ================ 페이징 관련 함수 ================
// 페이징 버튼 생성
const printPageNation = (pageInfo, mno, isReceived) => {
  const { page, totalpage, startbtn, endbtn } = pageInfo;
  const pagebox = document.querySelector(".pagebox");

  const html = `
        <li class="page-item">
            <a class="page-link" href="#" onclick="loadPage(${Math.max(1, page - 1)}, ${isReceived})">
                이전
            </a>
        </li>
        ${createPageButtons(startbtn, endbtn, page, isReceived)}
        <li class="page-item">
            <a class="page-link" href="#" onclick="loadPage(${Math.min(totalpage, page + 1)}, ${isReceived})">
                다음
            </a>
        </li>
    `;

  pagebox.innerHTML = html;
};

// 페이지 버튼 생성
const createPageButtons = (start, end, currentPage, isReceived) => {
  let buttons = "";
  for (let i = start; i <= end; i++) {
    buttons += `
            <li class="page-item">
                <a class="page-link ${currentPage === i ? "active" : ""}" 
                   href="#" 
                   onclick="loadPage(${i}, ${isReceived})">
                    ${i}
                </a>
            </li>
        `;
  }
  return buttons;
};

// 페이지 로드
const loadPage = (page, isReceived) => {
  isReceived ? loadReceivedMessages(page) : loadSentMessages(page);
};

// ================ 삭제 관련 함수 ================
// 받은 쪽지 삭제 확인
const confirmDeleteReceivedMessage = (meno, mno) => {
  if (confirm("정말 삭제하시겠습니까?")) {
    deleteReceivedMessage(meno, mno);
  }
};

// 보낸 쪽지 삭제 확인
const confirmDeleteSentMessage = (meno, mno) => {
  if (confirm("정말 삭제하시겠습니까?")) {
    deleteSentMessage(meno, mno);
  }
};

// 받은 쪽지 삭제
const deleteReceivedMessage = (meno, mno) => {
  const option = {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "include",
  };

  fetch(`/message/receive/delete.do?meno=${meno}`, option)
    .then((response) => {
      if (!response.ok) throw new Error(`HTTP 오류: ${response.status}`);
      return response.json();
    })
    .then((result) => {
      if (result.success) {
        alert("쪽지가 삭제되었습니다.");
        loadReceivedMessages(1);
      } else {
        alert("쪽지 삭제에 실패했습니다.");
      }
    })
    .catch((error) => {
      console.error("쪽지 삭제 실패:", error);
      alert("쪽지 삭제 중 오류가 발생했습니다.");
    });
};

// 보낸 쪽지 삭제
const deleteSentMessage = (meno, mno) => {
  const option = {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "include",
  };

  fetch(`/message/send/delete.do?meno=${meno}`, option)
    .then((response) => {
      if (!response.ok) throw new Error(`HTTP 오류: ${response.status}`);
      return response.json();
    })
    .then((result) => {
      if (result.success) {
        alert("쪽지가 삭제되었습니다.");
        loadSentMessages(1);
      } else {
        alert("쪽지 삭제에 실패했습니다.");
      }
    })
    .catch((error) => {
      console.error("쪽지 삭제 실패:", error);
      alert("쪽지 삭제 중 오류가 발생했습니다.");
    });
};

// ================ 초기화 ================
// 페이지 로드 시 이벤트 리스너 등록
document.addEventListener("DOMContentLoaded", () => {
  loadReceivedMessages(1);

  const sentTab = document.getElementById("sent-tab");
  const receivedTab = document.getElementById("received-tab");

  if (sentTab) {
    sentTab.addEventListener("click", () => loadSentMessages(1));
  }
  if (receivedTab) {
    receivedTab.addEventListener("click", () => loadReceivedMessages(1));
  }
});
