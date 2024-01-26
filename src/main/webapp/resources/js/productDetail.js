// replyAdd (Fetch 사용, JS)
const replyBtn = document.getElementById("replyAdd");
const replyList = document.getElementById("replyList");

const more = document.getElementById("more");

// 위임
replyList.addEventListener("click",(e)=>{
    if(e.target.getAttribute("id") == 'more'){
        let p = e.target.getAttribute("data-replyList-page");
        
        fetch("../reply/list?productNum="+URLSearchParams.getAttribute("data-product-num")+"&page="+(p*1+1),{
            method:"GET"
        })
        .then(r => r.text())
        .then(r => replyList.innerHTML = r)
    }
})

fetch("../reply/list?productNum="+URLSearchParams.getAttribute("data-product-num"),{
    method:"GET"
})
.then(r => r.text())
.then(r => replyList.innerHTML = r)


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
    })
});