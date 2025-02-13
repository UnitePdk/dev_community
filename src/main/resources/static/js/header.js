// [1] 로그인 정보 요청
const getLoginId = () => {
    // fetch option
    const option = {method : 'GET',}
    // DOM
    let header_right = document.querySelector('#header_right')
    let html = ``;
    // fetch
    fetch('/member/info.do', option)
        .then(r => r.json())
        .then(data => {
            console.log('로그인 상태') // 로그인 상태 확인
            html += `
                    <li class="nav-item"><a class="nav-link" href="#" onclick="logout()">로그아웃</a></li>
                    <li class="nav-item"><a class="nav-link" href="/member/info">마이페이지</a></li>
                    `
            header_right.innerHTML = html;
        })
        .catch(e => {
            console.log(e)
            console.log('로그아웃 상태')
            html += `<li class="nav-item"><a class="nav-link" href="/member/signup">회원가입</a></li>
                     <li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>`
            // 출력
            header_right.innerHTML = html;
        })
}
getLoginId();

// [2] 로그아웃
const logout = () => {
    const option = {method : "GET"}
    fetch("/member/logout.do", option)
        .then(r => r.json())
        .then(d => {
            if(d == true){alert('로그아웃'); location.href="/"}
        })
        .catch(e => console.log(e))
}