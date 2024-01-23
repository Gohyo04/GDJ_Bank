/**
 * 
 */
//  console.log("agreement");
 
//  const checkAll = document.getElementById("checkAll");
//  const checkList = document.getElementsByClassName("checks");
//  const btn = document.getElementById("btn");
//  const req = document.getElementsByClassName("req");

// checkAll.addEventListener("click",()=>{
// 	let v = checkAll.checked;

// 	if(checkAll.checked){
// 		for(let i=0;i<checkList.length;i++){
// 			checkList[i].checked = true;
// 		}	
// 	}else{
// 		for(let i=0;i<checkList.length;i++){
// 			checkList[i].checked = false;
// 		}	
// 	}
// });

// for(let c of checkList){
// 	c.addEventListener("click", function(){
// 		let flag = true;
// 		for(let ch of checkList){
// 			if(!ch.checked){
// 				flag=!flag;
// 				break;
// 			}
// 		}

// 		checkAll.checked=flag;

// 	})	
// }

// btn.addEventListener("click",(e)=>{
// 	e.preventDefault();
	
// 	let flag = true;

// 	for(let r of req){
// 		if(!r.checked){
// 			flag=false;
// 			break;
// 		}
// 	}

// 	if(flag){
// 		location.href="./join";
// 	}else{
// 		alert("필수 약관 동의");
// 	}

// });

//------------------------------------------------------------------
// jquery
$('#checkAll').click(() => {
	let v = $("#checkAll").prop("checked");
	$('.checks').prop("checked",v);
});

$('.checks').click(function(){
	let flag = true;

	$('.checks').each(function(idx, ch){

		if(!$(ch).prop('checked')){
			flag=!flag;
			return false;
		}
	});

	$("#checkAll").prop("checked",flag);
});

$('#btn').click((e)=>{
	e.preventDefault();
	
	let flag=true;
	$('.req').each((idx,r)=>{
		if(!$(r).prop('checked')){
			flag=!flag;
			return false;
		}
	});

	if(flag){
		location.href="join";
	}else{
		alert("필수 약관 동의");
	}

});








