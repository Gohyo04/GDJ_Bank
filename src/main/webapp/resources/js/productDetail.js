// replyAdd (Fetch 사용, JS)
const frm = document.getElementById("frm");
const up = document.getElementById("up");
const dele = document.getElementById("del");
const create = document.getElementById("create");
const more = document.getElementById("more")
const replyList = document.getElementById("replyList");
const replyAdd = document.getElementById("replyAdd");
console.log(replyList);
// modal update button
const replyUpdateButton = document.getElementById("replyUpdateButton");

getReplyList(1,up.getAttribute("data-product-num"));

// 모달 수정 버튼
replyUpdateButton.addEventListener("click",function(){
    // alert("update");

    let form = document.getElementById("replyUpdateForm");
    let formData = new FormData(form);

    fetch("../reply/update",
    {
        method:"post",
        body:formData
    }
    ).then(r => r.json()
    ).then(r => 
        {
            alert(r);

            if(r > 0){
                // td의 id 가져와서 Contents 변경
                let i = "replyContents"+document.getElementById("replyUpdateNum").value;
                i = document.getElementById(i);
                i.innerHTML = document.getElementById("replyUpdateContents").value;
            }else{
                alert("수정 실패");
            }
            // Modal Close 버튼을 강제로 클릭
            form.reset();
            //replyUpdateForm.reset();
            document.getElementById("replyCloseButton").click();
        }
    );
})

// 수정 버튼 (js 위임)
replyList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("update")){
        // modal textarea
        const replyUpdateContents = document.getElementById("replyUpdateContents");

        // td의 id 생성
        let i = 'replyContents'+e.target.getAttribute("data-replyNum");
        
        // 해당아이디에 td 가져오기
        const r = document.getElementById(i);
        // td 다음 형제의 내용 (userName)
        document.getElementById("replyWriter").value = r.nextSibling.innerHTML();
        // innerText / innerHTML 
        replyUpdateContents.value = r.innerHTML.trim();
        document.getElementById("replyUpdateNum").value = e.target.getAttribute("data-replyNum");
    }
})


// 삭제 버튼 (jquery 위임)
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
        td.setAttribute("id","replyContents"+r[i].replyNum);
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

            //data-bs-toggle="modal" data-bs-target="#exampleModal"
            b.setAttribute("data-bs-toggle","modal");
            b.setAttribute("data-bs-target","#replyUpdateModal")
            td.append(b);
            tr.append(td);

            replyList.append(tr);
        }
    }
}

// 댓글등록
replyAdd.addEventListener("click",()=>{
    console.log('add');
    const replyForm = document.getElementById("replyForm");
    const form = new FormData(replyForm);

    fetch("../reply/add",{
        method:"POST",
        body:form,
    })
    .then(res => res.json())
    .then(r => {
        replyList.innerHTML = "";
        
        makeList(r);
        replyForm.reset();
    })
});
