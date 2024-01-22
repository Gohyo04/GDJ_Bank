/**
 * 
 */
 console.log("agreement");
 
 const checkAll = document.getElementById("checkAll");
 const checkList = document.getElementsByClassName("checks");
 

checkAll.addEventListener("click",()=>{
	let v = checkAll.checked;

	if(checkAll.checked){
		for(let i=0;i<checkList.length;i++){
			checkList[i].checked = true;
		}	
	}else{
		for(let i=0;i<checkList.length;i++){
			checkList[i].checked = false;
		}	
	}
});

for(let c of checkList){
	c.addEventListener("click", function(){
		console.log(this.checked);
		if(!this.checked){
			checkAll.checked = this.checked;
		}else{
			checkAll.checked = this.checked;
		}
	})	
}

// jquery
$('#checkAll').click(() => {
	let v = $("#checkAll").prop("checked");
	$('.checkList').prop("checked",v);
});

$('.checkList').click(function(){
	console.log($(this).prop('checked'));
	
});










