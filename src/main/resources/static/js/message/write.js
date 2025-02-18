// * 페이지가 완전히 로드된 후 실행
window.onload = function () {
  document.querySelector("#sendMessageButton").addEventListener("click", sendMessage);
};

// * 썸머노트 실행
$(document).ready(function () {
  $("#summernote").summernote({
    height: 500,
    lang: "ko-KR",
    placeholder: "쪽지 내용을 입력해주세요",
  });
});

/**
 * ID로 회원번호(mno) 조회
 * @param {string} mid 회원 ID
 * @returns {Promise<number|null>} 회원번호 또는 null
 */
const findMnoById = async (mid) => {
  try {
    const response = await fetch(`/message/find-mno/${mid}`);
    if (!response.ok) {
      if (response.status === 404) {
        throw new Error("존재하지 않는 회원입니다.");
      }
      throw new Error("회원 정보 조회 중 오류가 발생했습니다.");
    }
    return await response.json();
  } catch (error) {
    console.error("회원번호 조회 실패:", error);
    throw error;
  }
};

/**
 * 현재 로그인한 사용자의 회원번호(mno)를 조회
 * @returns {Promise<number>} 사용자의 회원번호
 */
const getCurrentUserMno = async () => {
  try {
    const response = await fetch("/mno.do");
    if (!response.ok) {
      throw new Error("로그인 정보 조회에 실패했습니다.");
    }
    const mno = await response.json();
    if (!mno || mno === 0) {
      throw new Error("로그인이 필요합니다.");
    }
    return mno;
  } catch (error) {
    console.error("사용자 정보 조회 실패:", error);
    throw error;
  }
};

// * 메시지 전송 함수
async function sendMessage() {
  try {
    const receiverId = document.querySelector("#receiverId")?.value.trim();
    const metitle = document.querySelector("#messageTitle")?.value.trim();
    const mecontent = $("#summernote").summernote("code").trim();

    // 입력값 검증
    if (!receiverId || !metitle || !mecontent) {
      throw new Error("모든 필드를 입력해주세요.");
    }

    // 현재 로그인한 사용자의 mno와 수신자의 mno 가져오기
    const [senderMno, receiverMno] = await Promise.all([getCurrentUserMno(), findMnoById(receiverId)]);

    // 수신자 존재 여부 확인
    if (!receiverMno) {
      throw new Error("존재하지 않는 회원입니다.");
    }

    // 자기 자신에게 전송하는지 확인
    if (senderMno === receiverMno) {
      throw new Error("자기 자신에게는 메시지를 보낼 수 없습니다.");
    }

    // 메시지 데이터 구성
    const messageData = {
      sendermno: senderMno,
      receivermno: receiverMno,
      metitle: metitle,
      mecontent: mecontent,
    };

    console.log("전송 데이터:", messageData);

    const response = await fetch("/message/send.do", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(messageData),
    });

    if (!response.ok) {
      throw new Error("메시지 전송에 실패했습니다.");
    }

    const result = await response.json();

    if (result === true) {
      alert("메시지가 성공적으로 전송되었습니다.");
      location.href = "/message";
    } else {
      throw new Error("메시지 전송에 실패했습니다. 다시 시도해주세요.");
    }
  } catch (error) {
    console.error("메시지 전송 오류:", error);
    alert(error.message);
  }
}
