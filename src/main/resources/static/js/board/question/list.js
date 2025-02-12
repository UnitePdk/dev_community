// 문제 은행
const findAll = () => {
  const cno = new URL(location.href).searchParams.get("cno");

  const option = { method: "GET" };

  const tbody = document.querySelector("tbody");
  let html = "";

  fetch(`/board/question.do?page=${1}`, option)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      data.forEach((board) => {
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
