// 게시물 목록
const findAll = () => {
  let page = new URL(location.href).searchParams.get("page");
  if (page == null) page = 1;

  const cno = document.querySelector(".container").dataset.cno;

  let lno = new URL(location.href).searchParams.get("lno");
  if (lno == null) lno = -1;
  console.log(lno);

  let key = new URL(location.href).searchParams.get("key");
  if (key == null) key = "";
  let keyword = new URL(location.href).searchParams.get("keyword");
  if (keyword == null) keyword = "";

  const option = { method: "GET" };

  const tbody = document.querySelector("tbody");
  let html = "";

  fetch(
    `/board/findall.do?cno=${cno}&page=${page}&lno=${lno}&key=${key}&keyword=${keyword}`,
    option
  )
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      const list = data.data;
      list.forEach((board) => {
        html += `<tr>
                    <td> ${board.bno} </td>
                    <td> <a href="/board/view?bno=${board.bno}"> ${board.btitle} </a> </td>
                    <td> ${board.mname} </td>
                    <td> ${board.bview} </td>
                    <td> ${board.cdate} </td>
                </tr>`;
      }); // foreach end
      tbody.innerHTML = html;
      printPagenation(data, key, keyword);
    })
    .catch((e) => console.log(e));
};

// 페이지 바
const printPagenation = (data, key, keyword) => {
  const page = data.page;
  const totalpage = data.totalpage;
  const startbtn = data.startbtn;
  const endbtn = data.endbtn;

  const pagebox = document.querySelector(".pagebox");
  let html = "";

  html += `<li class="page-item"><a class="page-link" href="?page=${
    page <= 1 ? 1 : page - 1
  }&key=${key}&keyword=${keyword}"><</a></li>`;

  for (let index = startbtn; index <= endbtn; index++) {
    html += `<li class="page-item"><a class="page-link ${
      page == index ? "active" : ""
    }" href="?page=${index}&key=${key}&keyword=${keyword}">${index}</a></li>`;
  }

  html += `<li class="page-item"><a class="page-link" href="?page=${
    page >= totalpage ? totalpage : page + 1
  }&key=${key}&keyword=${keyword}">></a></li>`;

  pagebox.innerHTML = html;
};

// 검색
const onSearch = () => {
  const cno = document.querySelector(".container").dataset.cno;

  const key = document.querySelector(".key").value;
  const keyword = document.querySelector(".keyword").value;

  let lno = new URL(location.href).searchParams.get("lno");
  if (lno == null) lno = -1;

  location.href = `?cno=${cno}&page=1&lno=${lno}&key=${key}&keyword=${keyword}`;
};

// 엔터 키로 검색
const keywordEnter = document.querySelector(".keyword");
keywordEnter.addEventListener("keydown", (event) => {
  if (event.key === "Enter") onSearch();
});

// 언어 선택
const selectLang = (lno) => {
  const cno = document.querySelector(".container").dataset.cno;

  let key = new URL(location.href).searchParams.get("key");
  if (key == null) key = "";
  let keyword = new URL(location.href).searchParams.get("keyword");
  if (keyword == null) keyword = "";

  location.href = `?cno=${cno}&page=1&lno=${lno}&key=${key}&keyword=${keyword}`;
};

findAll();
