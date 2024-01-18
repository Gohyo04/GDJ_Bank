const upd = document.getElementById("update");
const dele = document.getElementById("del");
const frn = document.getElementById("frm");


upd.addEventListener('click', (e)=>{
	e.preventDefault();
	frn.submit();	
});

dele.addEventListener('click',(e)=>{
	e.preventDefault();
	frn.setAttribute('action', "./delete");
	frn.setAttribute('method',"post");
	frn.submit();
});