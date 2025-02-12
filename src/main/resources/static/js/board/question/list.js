// 문제 은행
const findAll = () => {
  let page = new URL(location.href).searchParams.get("page");
  if (page == null) page = 1;

  const option = { method: "GET" };

  const tbody = document.querySelector("tbody");
  let html = "";

  fetch(`/board/question.do?page=${page}`, option)
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
    })
    .catch((e) => console.log(e));
};
findAll();
