const del = document.getElementById("del");
const frm = document.getElementById("frm");
const up = document.getElementById("up");

 del.addEventListener("click", function(){
      let result = confirm("삭제할것인가요?");  

      if(result){
        frm.submit();  
      }
 });