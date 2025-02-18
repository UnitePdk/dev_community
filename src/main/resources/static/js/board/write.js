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
  const lno = document.querySelector(".language").value;
  const btitle = document.querySelector(".btitle").value;
  const bcontent = document.querySelector(".bcontent").value;

  let category = "";
  if (cno == 1) {
    category = "ask";
  } else if (cno == 2) {
    category = "advertise";
  } else if (cno == 3) {
    category = "tutorial";
  } else if (cno == 4) {
    category = "question";
  }

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
        location.href = `/board/${category}`;
      } else {
        alert("글쓰기 실패 : 로그인후 가능합니다. ");
      }
    })
    .catch((e) => {
      console.log(e);
    });
};

// 기존 글 불러오기
const getBoard = () => {
  const bno = new URL(location.href).searchParams.get("bno");

  fetch(`/board/view.do?index=${bno}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      document.querySelector(".category").value = data.cno;
      document.querySelector(".language").value = data.lno;
      document.querySelector(".btitle").value = data.btitle;
      document.querySelector(".bcontent").innerHTML = data.bcontent;
    })
    .catch((e) => {
      console.log(e);
    });
};

// 글 수정
const onUpdate = () => {
  const bno = new URL(location.href).searchParams.get("bno");

  const cno = document.querySelector(".category").value;
  let category = "";
  if (cno == 1) {
    category = "ask";
  } else if (cno == 2) {
    category = "advertise";
  } else if (cno == 3) {
    category = "tutorial";
  } else if (cno == 4) {
    category = "question";
  }

  const lno = document.querySelector(".language").value;
  const btitle = document.querySelector(".btitle").value;
  const bcontent = document.querySelector(".bcontent").value;

  const obj = {
    bno: bno,
    cno: cno,
    lno: lno,
    btitle: btitle,
    bcontent: bcontent,
  };

  const option = {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(obj),
  };

  fetch("/board/update.do", option)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      if (data == true) {
        alert("수정 성공");
        location.href = `/board/${category}`;
      } else {
        alert("수정 실패 : 로그인후 가능합니다. ");
      }
    })
    .catch((e) => {
      console.log(e);
    });
};
