document.addEventListener('DOMContentLoaded', function() {
    // 페이지 로드 시 받은 쪽지함 표시
    loadReceivedMessages();

    // 탭 전환 시 각각의 메시지 목록 로드
    document.getElementById('sent-tab').addEventListener('click', loadSentMessages);
    document.getElementById('received-tab').addEventListener('click', loadReceivedMessages);
});

// 받은 쪽지 목록 로드 함수
function loadReceivedMessages() {
    const loginMno = getCurrentUserMno();

    if (!loginMno) {
        alert('로그인이 필요합니다.');
        return;
    }

    console.log('받은 쪽지를 가져오는 중, mno:', loginMno);

    fetch(`/message/receive/find.do?receivermno=${loginMno}`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        credentials: 'include' // 로그인 정보를 쿠키로 포함
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP 오류 발생! 상태: ${response.status}`);
        }
        return response.json();
    })
    .then(messages => {
        console.log('받은 쪽지:', messages);

        const tbody = document.getElementById('receivedMessages');
        tbody.innerHTML = ''; // 기존 목록 초기화

        if (!Array.isArray(messages)) {
            console.error('예상한 메시지 배열이 아닌 값이 들어왔습니다:', messages);
            return;
        }

        // 받은 쪽지 목록 출력
        messages.forEach(message => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${escapeHtml(message.metitle)}</td>
                <td>${escapeHtml(message.sendmid)}</td>
                <td>${formatDate(message.medate)}</td>
                <td>
                    <button class="btn btn-danger btn-sm"
                            onclick="deleteReceivedMessage(${message.meno}, ${loginMno})">
                        삭제
                    </button>
                </td>
            `;
            tbody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('받은 쪽지 로드 실패:', error);
        alert('쪽지 목록을 불러오는데 실패했습니다.');
    });
}

// 보낸 쪽지 목록 로드 함수
function loadSentMessages() {
    const loginMno = getCurrentUserMno();

    if (!loginMno) {
        alert('로그인이 필요합니다.');
        return;
    }

    console.log('보낸 쪽지를 가져오는 중, mno:', loginMno);

    fetch(`/message/send/find.do?sendermno=${loginMno}`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        credentials: 'include'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP 오류 발생! 상태: ${response.status}`);
        }
        return response.json();
    })
    .then(messages => {
        console.log('보낸 쪽지:', messages);

        const tbody = document.getElementById('sentMessages');
        tbody.innerHTML = ''; // 기존 내용 비우기

        if (!Array.isArray(messages)) {
            console.error('예상한 메시지 배열이 아닌 값이 들어왔습니다:', messages);
            return;
        }

        // 보낸 쪽지 목록 출력
        messages.forEach(message => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${escapeHtml(message.metitle)}</td>
                <td>${escapeHtml(message.receivermid)}</td>
                <td>${formatDate(message.medate)}</td>
                <td>
                    <button class="btn btn-danger btn-sm"
                            onclick="deleteSentMessage(${message.meno}, ${loginMno})">
                        삭제
                    </button>
                </td>
            `;
            tbody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('보낸 쪽지 로드 실패:', error);
        alert('쪽지 목록을 불러오는데 실패했습니다.');
    });
}

// XSS 방지를 위한 HTML 이스케이프 함수
function escapeHtml(unsafe) {
    return unsafe
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}

// 날짜 포맷팅 함수
function formatDate(dateString) {
    if (!dateString) return '';
    const date = new Date(dateString);
    if (isNaN(date.getTime())) return dateString; // 유효하지 않은 날짜는 원본 반환

    return `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, '0')}-${String(date.getDate()).padStart(2, '0')}`;
}

// 현재 로그인한 사용자의 mno를 반환하는 함수
function getCurrentUserMno() {
    const mno = sessionStorage.getItem('mno');
    if (!mno) {
        console.error('로그인 정보가 없습니다.');
        return null;
    }
    return mno;
}

// 로그인 상태 확인
function checkLoginStatus() {
    const mno = getCurrentUserMno();
    if (!mno) {
        alert('로그인이 필요한 서비스입니다.');
        window.location.href = '/login'; // 로그인 페이지로 리다이렉트
        return false;
    }
    return true;
}
