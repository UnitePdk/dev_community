// * 썸머노트 실행
$(document).ready(function() {
  $('#summernote').summernote({
    height : 500 , // 썸머노트 게시판의 높이조절 속성
    lang : 'ko-KR', // 썸머노트 메뉴 한글화 속성
    placeholder : '게시물 내용 입력해주세요' // 입력 전에 가이드라인 제공 속성
  });
});

// 메시지 전송 함수
function sendMessage() {
    // 입력값 가져오기
    const receiverMno = document.querySelector('.receiverId').value; // 수정된 변수명
    const metitle = document.querySelector('.metitle').value;
    const mecontent = $('#summernote').summernote('code'); // 썸머노트에서 내용 가져오기

    // 입력값 검증
    if (!receiverMno || !metitle || !mecontent) {
        alert('모든 필드를 입력해주세요.');
        return;
    }

    // 로그인된 회원의 mno 가져오기
    fetch('/member/login/mno')
        .then(response => response.json())
        .then(senderMno => {
            console.log('로그인한 회원의 mno:', senderMno);

            // 메시지 데이터 구성
            const obj = {
                sendermno: senderMno,   // 발신자 mno 추가
                receivermno: receiverMno, // 수신자 mno
                metitle: metitle,
                mecontent: mecontent
            };

            // fetch API를 이용해 메시지 전송 요청
            return fetch('/message/send.do', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(obj)
            });
        })
        .then(response => response.json())
        .then(result => {
            if (result === true) {
                alert('메시지가 성공적으로 전송되었습니다.');
                location.href = "/message";  // 메시지 목록 페이지로 이동
            } else {
                alert('메시지 전송에 실패했습니다. 다시 시도해주세요.');
            }
        })
        .catch(error => {
            console.error('메시지 전송 오류:', error);
            alert('메시지 전송 중 오류가 발생했습니다.');
        });
}




 }
