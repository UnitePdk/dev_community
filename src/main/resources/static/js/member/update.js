// 내 정보 출력, info 메서드와 동일 
const info = () => {
    const option = {method : "GET"}
    fetch("/member/info.do", option)
        .then(r => r.json())
        .then(d => {
            if(d != ''){
                document.querySelector('.midInput').value = d.mid;
                document.querySelector('.mnameInput').value = d.mname;
                document.querySelector('.memailInput').value = d.memail;
                document.querySelector('.mphone').value = d.mphone;
                document.querySelector('.mbirthInput').value = d.mbirth;
            }
        })
        .catch(e => console.log(e))
}
info();

// 내 정보 수정 
const onUpdate = () => {
    let mname = document.querySelector('.mnameInput').value;
    let memail = document.querySelector('.memailInput').value;
    let mphone = document.querySelector('.mphoneInput').value;

    let obj = {
        mname : mname,
        memail : memail,
        mphone : mphone
    }

    const option = {
        method : "PUT", 
        headers : {'Content-Type':'application/json'},
        body : JSON.stringify(obj)
    }

    fetch('/member/update.do', option)
        .then(r => r.json())
        .then(d => {
            if(d == true){alert('회원 수정 성공'); location.href = "/member/info";}
            else{alert('회원 수정 실패');}
        })
        .catch(e => console.log(e))
}

