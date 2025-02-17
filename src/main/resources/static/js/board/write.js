// * 썸머노트 실행
$(document).ready(function () {
  $("#summernote").summernote({
    height: 500, // 썸머노트 게시판의 높이조절 속성
    lang: "ko-KR", // 썸머노트 메뉴 한글화 속성
    placeholder: "게시물 내용 입력해주세요", // 입력 전에 가이드라인 제공 속성
  });
});

// 글쓰기
const onWrite = () => {
  const cno = document.querySelector(".category").value;
  const btitle = document.querySelector(".btitle").value;
  const bcontent = document.querySelector(".bcontent").value;
  const lno = 1;

  const obj = { cno: cno, lno: lno, btitle: btitle, bcontent: bcontent };

  const option = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(obj),
  };
  fetch("/board/write.do", option)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      if (data == true) {
        alert("글쓰기 성공");
        location.href = `/board/ask`;
      } else {
        alert("글쓰기 실패 : 로그인후 가능합니다. ");
      }
    })
    .catch((e) => {
      console.log(e);
    });
};
