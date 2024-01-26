/**
 * 
 */
 const checkAll = document.getElementById("checkAll");
 const checklist = document.getElementsByClassName("checks");
 const delBtn = document.getElementById("del");


// console.log(checkAll);
//  checkAll.addEventListener("click",()=>{
//     console.log(checkAll.value)
//     // if(checkAll.checked){
//     //     for(let ch of checklist){
//     //         ch.checked = true;
//     //     }
//     // }else{
//     //     for(let ch of checklist){
//     //         ch.checked = false;
//     //     }
//     // }
//  });
 
// for(let ch of checklist){
//     ch.addEventListener("click",()=>{
//         let flag = true;
//         for(let ch of checklist){
//             if(!ch.checked){
//                 flag = !flag;
//                 break;
//             }
//         }
//         flag = flag;
//     })
//  };



 $('#checkAll').click(()=>{
    let v = $("#checkAll").prop("checked");
    
    $('.checks').prop("checked", v);
});

$('#tb').on("click","checks",function(){
    let flag=true;
    
    $('.checks').each(function(idx, c){
        
        if(!$(c).prop('checked')){
            flag=!flag;
            return false;
        }
    });

    $("#checkAll").prop("checked", flag);
});

 //  delBtn.addEventListener("click",()=>{
    
//     for(let ch of checklist){
//         if(ch.checked){
//             ar.push(ch.value);
//         }
//     }
//     console.log(ar);
// });

$("#add").click(function(){
    $("#deleteForm").attr("action","../account/add")
    $("#deleteForm").submit();
});

$("#del").click(()=>{
    let ar = [];
    $(".checks").each((index, item)=>{
        if(item.checked){
            ar.push($(item).val());
        }
    });

    deleteWithJquery(ar);
    //deleteWithFetch(ar);
    console.log(ar);
});

function deleteWithFetch(ar){

    // let param = "";
    // ar.forEach(element => {
    //   param=param+"productNum="+element+"&";
    // });

    let deleteForm = document.getElementById("deleteForm");

    let form = new FormData(deleteForm);

    fetch("./delete",{
        method:"POST",
        // headers:{
        //     "Content-type":"application/x-www-form-urlencoded"
        // },
        //body:"productNum="+ar,
        body:form
    })
    .then(response => response.text())
    .then(response=>{
        console.log(response)
        $("#tb").html(response.trim());
    });
}


function deleteWithJquery(ar){

    let form = new FormData($("#deleteForm")[0]);
    $.ajax({
        method:"POST",
        url:"./delete",
        traditional:true,       // 배열을 넘길때 사용
        contentType:false,
        processData:false,
        data:form,
        success:function(result){
            // if(result > 0){
                //1.
             //location.reload()

            // 2. Element들을 삭제
            // checkElement.foreach((e)=>{
            //     $(e).parent().parent().parent().remove();
            // })
            // }
            // 3. DB에서 조회를 다시 해서 html()
            $("#tb").html(result);
            
        },
        error:function(){
            alert("알수없는 에러");
        }
    })
}

//  $('#wish').click(()=>{
//     fetch("/wishlist/add?productNum="+$('#productNum').val(),{
//         method:"GET"
//     })
//     .then(res => {
//         return res.text()
//     })
//     .then(res => {
//         let result = res.trim();
//         if(result == 1){
//             alert("등록성공");
//             if(confirm("장바구니로?")){
//                 location.href="/wishlist/list"
//             }
//         }else{
//             alert("등록실패");
//             location.href="/product/list"
//         }
//     })
//  });









// JQuery
$('#wish').click(()=>{
    $.ajax({
        url:"/wishlist/add",
        method:"GET",
        data:{
            productNum:$('#productNum').val(),
            userName:$('#userName').val()
        },
        success:function(data){
            console.log(data);
            let d = data.trim();
            if(d == 1){
                alert("등록성공");
                if(confirm("장바구니로")){
                    location.href="/wishlist/list"
                }
            }else{
                alert("등록실패");
                location.href="/product/list"
            }
        },
        error:function(data){
        	console.log(data);
            console.log("실패");
        }
     });
});
 
 

