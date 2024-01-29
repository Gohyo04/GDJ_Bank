// replyAdd (Fetch 사용, JS)
const frm = document.getElementById("frm");
const up = document.getElementById("up");
const dele = document.getElementById("del");
const create = document.getElementById("create");
const more = document.getElementById("more")
const replyList = document.getElementById("replyList");


getReplyList(1,up.getAttribute("data-product-num"));

// 삭제 버튼
$("#replyList").on("click", ".del", function(){
    let n = $(this).attr("data-replyNum");

    fetch("../reply/delete",{
        method:"POST",
        body:"replyNum="+n+"&productNum="+up.getAttribute("data-product-num")
    }
    ).then(r => r.json()
    ).then(r => {
        replyList.innerHTML = "";
        makeList(r);
    })
})


// 더보기
more.addEventListener("click",()=>{
    let p = more.getAttribute("data-replyList-page");       // 현재 페이지 번호
    let a = more.getAttribute("data-replyList-totalPage");  // 전체 페이지 번호
    

    if(p>a){
        alert("마지막 페이지");
    }

    getReplyList(p, up.getAttribute("data-product-num"));

    // fetch("../reply/list?productNum="+up.getAttribute()+"&page="+p, {
    //     method:"GET"
    // })
    //     .then(r => r.text())
    //     .then(r => $("#replyList").append(r))
});


// list 가져오는 함수
function getReplyList(page, num){

    fetch("../reply/list?page="+page+"&productNum"+num,
    {
        method:"GET"
    }
    ).then(r => r.json()
    ).then(r => {
        
        makeList(r);
    })
}

function makeList(r){
    more.setAttribute("data-replyList-page", r.pager.page*1+1);
    more.setAttribute("data-replyList-totalPage", r.pager.totalPage);
    let userName = replyList.getAttribute("data-user");
    r = r.datas;
    
    for(leti=0;i<r.length;i++){
        let tr = document.createElement("tr");
        
        let td = document.createElement("td");
        td.innerHTML = r[i].replyContents;
        tr.append(td);
        
        td = document.createElement("td");
        td.innerHTML = r[i].userName;
        tr.append(td);
        
        td = document.createElement("td");
        let d = new Date(r[i].replyDate);
        td.innerHTML = d.getFullYear()+"."+(d.getMonth()+1)+"."+d.getDate();
        tr.append(td);


        // userName == i.userName
        if(userName == r[i].userName){

            td = document.createElement("td");
            let b = document.createElement("button");
            b.innerHTML="삭제";
            b.setAttribute("class","del");
            b.setAttribute("data-replyNum", r[i].replyNum);

            td.append(b);
            tr.append(td);

            td = document.createElement("td");
            b = document.createElement("button");
            b.innerHTML="수정";
            b.setAttribute("class","update");
            b.setAttribute("data-replyNum", r[i].replyNum);
            td.append(b);
            tr.append(td);

            replyList.append(tr);
        }
    }
}

// 댓글등록
replyBtn.addEventListener("click",()=>{
    const replyForm = document.getElementById("replyForm");
    const form = new FormData(replyForm);

    fetch("../reply/add",{
        method:"POST",
        body:form,
    })
    .then(res => res.text())
    .then(r => {
        replyList.innerHTML = "";
        
        makeList(r);
        replyForm.reset();
    })
});
