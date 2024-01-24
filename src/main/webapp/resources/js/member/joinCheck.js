console.log('joinCheck');

// const pw = document.getElementById("password");
// const pwch = document.getElementById("passwordCh");
// const msg = document.getElementById("passwordResult");
// const msgch = document.getElementById("passwordCheckResult");
// const nameIn = document.getElementById("name");
// const userName = document.getElementById("userName");
// const eamil = document.getElementById("email");
// const phone = document.getElementById("phone");
// const address = document.getElementById("address");


// const btn = document.getElementById("joinBtn");

// pw.addEventListener("blur",()=>{
//     let leng = pw.value.length;
//     if(leng < 8){
//         msg.innerText = "최소 8자 이상이여야합니다.";
//         msg.style.color = "red";
//     }else{
//         msg.innerText = "OK";
// 		   msg.style.color = "green";
//     }
// });

// pwch.addEventListener("change",()=>{
//     if(pw.value != pwch.value){
//         msgch.innerText = "비밀번호가 일치하지 않습니다.";
//         msgch.style.color = "red";
//     }else{
//         msgch.innerText = "OK";
// 		   msgch.style.color = "green";
//     }
// });

// btn.addEventListener("click", (e)=>{
//     let m = "";
    
//     e.preventDefault();
//     if(pw.value == pwch.value && pw.value.length > 7){
//         // alert("비밀번호 통과");
//         m.innerText += "비밀번호 통과\n";
//     }else{
//         // alert("비밀번호를 확인해주세요");
//         m.innerText += "비밀번호를 확인해주세요\n";
//     }
//     if(nameIn.value == null){
//         // alert("이름을 입력해주세요");
//         m.innerText += "이름을 입력해주세요\n";
//     }
//     if(userName.value == null){
//         m.innerText += "아이디를 입력해주세요\n";
//     }
//     if(eamil.value == null){
//         m.innerText += "이메일을 입력해주세요\n";
//     }
//     if(phone.value == null){
//         m.innerText += "번호를 입력해주세요\n";
//     }
//     if(address.value == null){
//         m.innerText += "주소를 입력해주세요\n";
//     }
//     alert(m);
// });






//JQuery
const nameIn = document.getElementById("name");
const userName = document.getElementById("userName");
const eamil = document.getElementById("email");
const phone = document.getElementById("phone");
const address = document.getElementById("address");




//---------JQuery-------------
$('#password').blur(()=>{
    let leng = $('#password').val().length;
    if(leng < 8){
        $('#passwordResult').html("최소 8자 이상이여야합니다.");
    }else{
        $('#passwordResult').html("OK");
    }
});

$('#passwordCh').keyup(()=>{
    if($('#password').val() != $('#passwordCh').val()){
        $('#passwordCheckResult').html("비밀번호가 일치하지않습니다.");
    }else{
        $('#passwordCheckResult').html("OK");
    }
});

$('#joinBtn').click(()=>{
    if($('#password').val() == $('#passwordCh').val() && $('#password').val().length > 7){
        alert("비밀번호 통과");
    }else{
        alert("비밀번호를 확인해주세요");
    }
});

$("#userName").blur(()=>{
    fetch("./idCheck?userName="+$('#userName').val(),{
        method:"GET"
    })
    .then(response => response.text())
    .then(response => response.trim())
    .then(response => {
        if(response == 1){
            
        }else{

        }
})
    
});
