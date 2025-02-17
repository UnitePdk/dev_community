// 내 정보 출력
const info = () => {
    const option = {method : "GET"}
    fetch("/member/info.do", option)
        .then(r => r.json())
        .then(data => {
            if(data != ''){
                console.log(data);
                document.querySelector('.midInput').value = data.mid;
                document.querySelector('.mnameInput').value = data.mname;
                document.querySelector('.memailInput').value = data.memail;
                document.querySelector('.mphoneInput').value = data.mphone;
                document.querySelector('.mbirthInput').value = data.mbirth;
            }
        })
        .catch(e => console.log(e))
}
info();

// 회원 탈퇴
const onDelete = () => {
    let result = confirm('정말 탈퇴 하시겠습니까?')
    if(result == false){return;}
    const option = {method : "DELETE"}
    fetch("/member/delete.do", option)
        .then(r => r.json())
        .then(d => {
            if(d == true){alert('회원 탈퇴 성공'); location.href='/';}
            else{alert('회원 탈퇴 실패')}
        })
        .catch(e => console.log(e))
}