// Javascript
// console.log("fileManager");

// const fileAdd = document.getElementById("fileAdd");
// const fileList = document.getElementById("fileList");

// let c = 1;
// fileAdd.addEventListener("click",()=>{
//     if(c > 5){
//         alert("파일은 5개 까지만");
//     }

//     console.log("fileAdd")
//     let div = document.createElement("div");
//     let input = document.createElement("input");
//     let span = document.createElement("span");

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

//     fileList.appendChild(div);
//     div.appendChild(input);
//     div.appendChild(span);
//     span.appendChild(t);

//     c++;
// });



// JQuery

let cnt = 1;
$("#fileAdd").click(() => {
    // let element = '<div clas="input-group">';
    // element += '<input class="form-control" type="file" name="attachs">';
    // element += '<span class="input-group-text text-danger">X</span>';
    // element += '</div>';
    // $("#fileList").append(element);

    if(cnt > 5){
        alert("파일은 5개 까지만");
    }else{
    

    let element = `                            
    <div class="input-group my-2">
        <input class="form-control" type="file" name="attachs">
        <span class="input-group-text text-danger del">X</span>
    </div>`

    $("#fileList").append(element);
    }
    cnt++;
});

$(".del").click(()=>{
    alert("Del Click");
});






















