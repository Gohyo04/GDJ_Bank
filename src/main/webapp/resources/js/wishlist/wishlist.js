/**
 * 
 */
 const btn = document.getElementById("wish");


 $('#wish').click(()=>{
    fetch("/wishlist/add?productNum="+$('#productNum').val(),{
        method:"GET"
    })
    .then(res => {
        return res.text()
    })
    .then(res => {
        let result = res.trim();
        if(result == 1){
            alert("등록성공");
            if(confirm("장바구니로?")){
                location.href="/wishlist/list"
            }
        }else{
            alert("등록실패");
            location.href="/product/list"
        }
    })
 });
 