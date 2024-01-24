// Javascript
// console.log("fileManager");

// const fileAdd = document.getElementById("fileAdd");
// const fileList = document.getElementById("fileList");
// const del =document.getElementById("del");

// let count = 0;
// let max = 5;

// fileList.addEventListener("click",(e)=>{
//     console.log(e);
//     console.log(e.target);
//     console.log(e.currentTarget);
//     if(e.target.classList.contains('del')){
//         // e.target.parentNode.remove();
//         let id = e.target.getAttribute("data-file-id");
//         document.getElementById(id).remove();
//         count--;
//     }
// });

// let idx = 0;

// fileAdd.addEventListener("click",()=>{
//     idx++;
//     if(count >= max){
//         alert("파일은 5개 까지만");
//         return;
//     }

//     count++;
//     idx++;

//     console.log("fileAdd")
//     let div = document.createElement("div");
//     let input = document.createElement("input");
//     let span = document.createElement("span");

//     div = document.createAttribute("id");
//     div.value = "file"+idx;

//     let t = document.createTextNode("X");

//     let f = document.createAttribute("type")
//     f.value = "file";
//     let n = document.createAttribute("name");
//     n.value = "attachs";

//     div.className = "input-group my-2";
//     input.className = "form-control";
//     input.setAttributeNode(f);
//     input.setAttributeNode(n);

//     span.className = "input-group-text text-danger del";

//     n = document.createAttribute("data-file-id");
//     n.value = "file"+idx;

//     input.setAttributeNode(ac);
//     div.appendChild(child);

//     fileList.appendChild(div);
//     div.appendChild(input);
//     div.appendChild(span);
//     span.appendChild(t);


// });



// JQuery
count = $("#fileList").attr("data-file-count");
max = $("#fileList").attr("data-file-max");

$("#fileList").on("click",".del", function(){
    $(this).parent().remove();
    count--;
});

$("#fileAdd").click(() => {
    // let element = '<div clas="input-group">';
    // element += '<input class="form-control" type="file" name="attachs">';
    // element += '<span class="input-group-text text-danger">X</span>';
    // element += '</div>';
    // $("#fileList").append(element);

    if(count >= max){
        alert("파일은 5개 까지만");
        return;
    }
    

    let element = `                            
    <div class="input-group my-2">
        <input class="form-control" type="file" name="attachs">
        <span class="input-group-text text-danger del">X</span>
    </div>`

    $("#fileList").append(element);
    
    count++;
});

$(".del").click(()=>{
    alert("Del Click");
});






















