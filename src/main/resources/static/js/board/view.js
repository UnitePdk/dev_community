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
