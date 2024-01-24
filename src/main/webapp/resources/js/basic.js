


let btn = document.getElementById("btn");
let btn2 = document.getElementById("btn2");


btn.addEventListener("click",()=>{
    console.log("Ajax 시작");

    fetch("/notice/list", {
        method:"GET",
    }).then(response=> response.text())
    .then((res)=>{
        document.getElementById("result").innerHTML=res;
    });
    
    console.log("Ajax 끝");
});

btn2.addEventListener("click", function(){
    let t = document.getElementById("title").value;
    let c = document.getElementById("contents").value;

    fetch("/notice/add", {
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"noticeTitle="+t+"&noticeContents="+c
    })
    .then(res => res.text())
    .then(res => console.log(res));

});








