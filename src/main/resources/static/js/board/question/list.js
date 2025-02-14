// 문제 은행
const findAll = () => {
  let page = new URL(location.href).searchParams.get("page");
  if (page == null) page = 1;

  let cno = document.querySelector(".container").dataset.cno;

  // 샘플 데이터
  const language = 1;

  const option = { method: "GET" };

  const tbody = document.querySelector("tbody");
  let html = "";

  fetch(
    `/board/findall.do?cno=${cno}&page=${page}&language=${language}&key&keyword`,
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
      printPagenation(data);
    })
    .catch((e) => console.log(e));
};

const printPagenation = (data) => {
  const page = data.page;
  const totalpage = data.totalpage;
  const startbtn = data.startbtn;
  const endbtn = data.endbtn;

  const pagebox = document.querySelector(".pagebox");
  let html = "";

  html += `<li class="page-item"><a class="page-link" href="?page=${
    page - 1
  }"><</a></li>`;

  for (let index = startbtn; index <= endbtn; index++) {
    html += `<li class="page-item"><a class="page-link ${
      page == index ? "active" : ""
    }" href="?page=${index}">${index}</a></li>`;
  }

  html += `<li class="page-item"><a class="page-link" href="?page=${
    page + 1
  }">></a></li>`;

  pagebox.innerHTML = html;
};

findAll();
