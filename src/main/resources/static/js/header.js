// [1] 로그인 정보 요청
const getLoginId = () => {
    // DOM
    let header_right = document.querySelector('.header_right')
    let html = ``;
    // fetch option
    const option = {method : 'GET',}
    // fetch
    fetch('/member/info.do', option)
        .then(r => r.json)
        .then(data => {
            console.log('로그인 상태') // 로그인 상태 확인
            html += `
                    <li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>
                    <li class="nav-item"><a class="nav-link" href="/member/signup">회원가입</a></li>
                    `
            header_right.innerHTML = html;
        })
        .catch(e => {
            console.log(e);
            html += `<li class="nav-item"><a class="nav-link" href="/member/signup">회원가입</a></li>
                     <li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>`
            // 출력
            header_right.innerHTML = html;
        })
}
getLoginId();