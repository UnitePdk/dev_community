// 문제은행 개별 게시물 조회
const onFind = () => {
  const bno = new URL(location.href).searchParams.get("bno");

  fetch(`/board/view.do?index=${bno}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      document.querySelector(".mnameB").innerHTML = data.mname;
      document.querySelector(".bviewB").innerHTML = data.bview;
      document.querySelector(".cdateB").innerHTML = data.cdate;
      document.querySelector(".cnameB").innerHTML = data.cname;
      document.querySelector(".btitleB").innerHTML = data.btitle;
      document.querySelector(".bcontentB").innerHTML = data.bcontent;
      document.querySelector(".blikeB").innerHTML = data.blike;
      document.querySelector(".blike").innerHTML = data.blike;
    })
    .catch((e) => {
      console.log(e);
    });
};
onFind();

const boardLike = () => {
  console.log("좋아요");
};

const getBno = () => {
  const bno = new URL(location.href).searchParams.get("bno");

  return bno;
};

// 수정, 삭제 버튼

// 수정
const updateLink = () => {
  const bno = new URL(location.href).searchParams.get("bno");
  location.href = `/board/update?bno=${bno}`;
};

// 삭제
const onDelete = () => {
  const bno = new URL(location.href).searchParams.get("bno");

  fetch(`/board/delete.do?index=${bno}`, { method: "DELETE" })
    .then((response) => response.json())
    .then((data) => {
      if (data == 1) {
        alert("게시글이 삭제되었습니다");
        location.href = "/board/ask";
      } else if (data == 2) {
        alert("게시글이 삭제되었습니다");
        location.href = "/board/advertise";
      } else if (data == 3) {
        alert("게시글이 삭제되었습니다");
        location.href = "/board/tutorial";
      } else if (data == 4) {
        alert("게시글이 삭제되었습니다");
        location.href = "/board/question";
      } else alert("삭제 실패: 관리자에게 문의하세요");
    });
};
