const  signUp = () => {
    
    const mname = document.querySelector('.mnameInput').value;
    const mid = document.querySelector('.midInput').value;
    const mpwd = document.querySelector('.mpwdInput').value;
    const mpwdConfirm = document.querySelector('.mpwdConfirmInput').value;
    const memail = document.querySelector('.memailInput').value;
    const mphone = document.querySelector('.mphoneInput').value;
    const mbirth = document.querySelector('.mbirthInput').value;

    // 유효성 검사
    if(mpwd != mpwdConfirm){
        alert('비밀번호가 일치하지 않습니다. 다시 시도해주세요.');
        return;
    }


    //const signupForm = document.querySelector('#signupForm');

    //const signupData = new FormData(signupForm);
    //console.log(signupForm);

    
    const obj = {
        mname : mname,
        mid : mid,
        mpwd : mpwd,
        memail : memail,
        mphone : mphone,
        mbirth : mbirth
    }
    

    const option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(obj)
    }

    fetch("/member/signup.do", option)
        .then(r => r.json())
        .then(d => {
            if(d == true){alert('회원가입 성공'); location.href="/member/login";}
            else{alert('회원가입 실패')}
        })
        .catch(e => {
            console.log(e);
            alert('시스템 오류, 관리자에게 문의하세요.')
        })
        

}