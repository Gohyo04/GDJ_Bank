// replyAdd (Fetch 사용, JS)
const replyBtn = document.getElementById("replyAdd");
const replyList = document.getElementById("replyList");

const more = document.getElementById("more");

// 위임
// replyList.addEventListener("click",(e)=>{
//     if(e.target.getAttribute("id") == 'more'){
//         let p = e.target.getAttribute("data-replyList-page");
        
//         fetch("../reply/list?productNum="+up.getAttribute("data-product-num")+"&page="+(p*1+1),{
//             method:"GET"
//         })
//         .then(r => r.text())
//         .then(r => replyList.innerHTML = r)
//     }
// })

more.addEventListener("click",()=>{
    let p = more.getAttribute("data-replyList-page");       // 현재 페이지 번호
    let a = more.getAttribute("data-replyList-totalPage");  // 전체 페이지 번호
    p = p*1+1;

    if(p>a){
        alert("마지막 페이지");
    }

    more.setAttribute("data-replyList-page",p)

    fetch("../reply/list?productNum="+up.getAttribute()+"&page="+p, {
        method:"GET"
    })
        .then(r => r.text())
        .then(r => $("#replyList").append(r))
});

// fetch("../reply/list?productNum="+up.getAttribute("data-product-num"),{
//     method:"GET"
// })
// .then(r => r.text())
// .then(r => replyList.innerHTML = r)


replyBtn.addEventListener("click",()=>{
    const replyForm = document.getElementById("replyForm");
    const form = new FormData(replyForm);

    fetch("../reply/add",{
        method:"POST",
        body:form,
    })
    .then(res => res.text())
    .then(res => {
        replyList.innerHTML = res.trim()
        replyForm.reset();
        more.setAttribute("data-replyList-page", 1);
    })
});