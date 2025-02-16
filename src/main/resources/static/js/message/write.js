// 메시지 전송 함수
 function sendMessage() {
     // 입력값 가져오기
     const receiverId = document.querySelector('.receiverId').value;
     const metitle = document.querySelector('.metitle').value;
     const mecontent = $('#summernote').summernote('code');  // 썸머노트에서 내용을 가져오기

     // 입력값 검증
     if (!receiverId || !metitle || !mecontent) {
         alert('모든 필드를 입력해주세요.');
         return;
     }

     // 메시지 데이터 구성
     const obj = {
         receiverId: receiverId,
         metitle: metitle,
         mecontent: mecontent
     };

     // fetch API 호출
    fetch('/message/send.do', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(obj)
    })
    .then(response => {
        if (!response.ok) {
            return response.text();  // 응답 내용을 텍스트로 가져오기
        }
        return response.json();  // JSON 형식으로 반환
    })
    .then(data => {
        console.log(data);  // 응답 내용 확인
        if (data) {
            alert('메시지가 성공적으로 전송되었습니다.');
            location.href = `/message?sendermno=${loginMno}`;
        } else {
            alert('메시지 전송에 실패했습니다. 다시 시도해주세요.');
        }
    })
    .catch(e => {
        console.log(e);
        alert('메시지 전송 중 오류가 발생했습니다.');
    });

 }
