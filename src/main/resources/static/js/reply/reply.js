console.log("reply.js open");

// const onReplyWrite = () => {
//     // console.log("reply.js open");
// }

// // 페이지 로드 시 댓글 목록 불러오기
// document.addEventListener("DOMContentLoaded", function () {
//     getReplies(); // 페이지가 로드될 때 댓글 목록을 가져옵니다.
// });

// 댓글 목록 불러오기
function getReplies() {
    const bno = getBno();

    fetch(`/reply/findall.do?bno=${bno}`)
        .then(response => response.json())
        .then(data => {
            const replyList = document.querySelector(".reply-list");
            replyList.innerHTML = ""; // 기존 댓글 초기화

            data.forEach(reply => {
                const replyItem = document.createElement("div");
                replyItem.classList.add("reply");
                replyItem.setAttribute("data-rno", reply.rno); // 댓글 번호를 저장

                replyItem.innerHTML = `
                    <div class="reply-header">
                        <div class="reply-author">
                            <div class="author-profile"></div>
                            <span class="mname">${reply.mname}</span>
                        </div>
                    </div>
                    <div class="rcontent">${reply.rcontent}</div>
                    <div class="reply-action">
                        <div class="action-button" onclick="onReplyLike(${reply.rno})">
                            <span class="heart">♥</span>
                            <span class="relike">${reply.relike}</span>
                        </div>
                        <span class="cdate">${reply.cdate}</span>
                    </div>
                    <div class="edit-delete-buttons">
                        <button class="edit-button" onclick="onReplyUpdate(${reply.rno})">수정</button>
                        <button class="delete-button" onclick="onReplyDelete(${reply.rno})">삭제</button>
                    </div>
                `;
                replyList.appendChild(replyItem);
            });
        })
        .catch(error => console.error("댓글 불러오기 실패:", error));
}

getReplies();

// 댓글 작성
function onReplyWrite() {
   
    const bno = getBno();
    
    if (!bno || bno === "0") {
        alert("잘못된 게시글 번호입니다.");
        return;
    }

    const rcontent = document.querySelector(".rcontentInput").value;
    if (!rcontent) {
        alert("댓글을 입력하세요!");
        return;
    }

    const replyData = { bno: bno, rcontent: rcontent, relike : 0 };

    fetch("/reply/write.do", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(replyData)
    })
        .then(response => response.json())
        .then(result => {
            if (result == true) {
                alert("댓글이 등록되었습니다!");
                document.querySelector(".rcontentInput").value = ""; // 입력 필드 초기화
                getReplies(); // 댓글 목록 다시 불러오기
            } else {
                alert("댓글 등록 실패!");
            }
        })
        .catch(error => console.error("댓글 작성 실패:", error));
}

// 댓글 수정
function onReplyUpdate(rno) {
    const newContent = prompt("수정할 내용을 입력하세요:");
    if (!newContent) return;

    const updateData = { rno: rno, rcontent: newContent };

    fetch("/reply/update.do", {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updateData)
    })
        .then(response => response.json())
        .then(result => {
            if (result) {
                alert("댓글이 수정되었습니다!");
                getReplies(); // 댓글 목록 다시 불러오기
            } else {
                alert("댓글 수정 실패!");
            }
        })
        .catch(error => console.error("댓글 수정 실패:", error));
}

// 댓글 삭제
function onReplyDelete(rno) {
    if (!confirm("정말 삭제하시겠습니까?")) return;

    fetch(`/reply/delete.do?rno=${rno}`, { method: "DELETE" })
        .then(response => response.json())
        .then(result => {
            if (result) {
                alert("댓글이 삭제되었습니다!");
                getReplies(); // 댓글 목록 다시 불러오기
            } else {
                alert("댓글 삭제 실패!");
            }
        })
        .catch(error => console.error("댓글 삭제 실패:", error));
}

// 댓글 좋아요 (토글 방식)
function onReplyLike(rno) {
    const relikeData = { rno: rno };

    fetch(`/reply/like/add.do`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(relikeData)
    })
        .then(response => response.json())
        .then(result => {
            if (result) {
                getReplies(); // 좋아요 수 갱신
            } else {
                alert("이미 좋아요를 눌렀거나 실패했습니다.");
            }
        })
        .catch(error => console.error("좋아요 처리 실패:", error));
}
