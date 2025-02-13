const login = () => {
    let mid = document.querySelector('.midInput').value;
    let mpwd = document.querySelector('.mpwdInput').value;

    let obj = {
        mid : mid,
        mpwd : mpwd
    }

    const option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(obj)
    }

    fetch('/member/login.do', option)
        .then(r => r.json())
        .then(d => {
            if(d == true){alert('로그인 성공'); location.href = "/"}
            else{alert('로그인 실패, 회원정보를 확인하세요')}
        })
        .catch(e => {
            alert('시스템 오류, 관리자에게 문의하세요.');
            console.log(e);
        })
}