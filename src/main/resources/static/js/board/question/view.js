// 문제은행 개별 게시물 조회
const onFind = () => {
  const bno = new URL(location.href).searchParams.get("bno");

  fetch(`/board/view.do?bno=${bno}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      document.querySelector(".mid").innerHTML = data.mid;
      document.querySelector(".bview").innerHTML = data.bview;
      document.querySelector(".cdate").innerHTML = data.cdate;

      document.querySelector(".btitle").innerHTML = data.btitle;
      document.querySelector(".bcontent").innerHTML = data.bcontent;
    })
    .catch((e) => {
      console.log(e);
    });
};
onFind();
