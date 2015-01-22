var rotateArray = new Array();

function rotateArrayfun(form) {
arr = form.addnumbers.value;
var rotateArray = arr.split(",");
var num = parseInt(form.numofrotations.value);

for (var i = 0; i < num; i++) {
for(var j = 0; j < rotateArray.length - 1; j++) {
    var temp = rotateArray[j+1];
    rotateArray[j+1] = rotateArray[0];
    rotateArray[0] = temp;
}
}
alert(rotateArray);
}   
