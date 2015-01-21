function rotateArray() {
    var elements = prompt("Please enter the numbers saparated by ,");
    var elementsarray = elements.split(",");
    var number = parseInt(prompt("Please enter the number of times rotate the array"));
    document.getElementById("unrotate").innerHTML = "before rotate the elements in array are:"+elementsarray;
    if (elements != null) {
       rotate(elementsarray , number);
    }
    
}
function rotate(elementsarray , number) {
     if(number !=0) {
         var temp=elementsarray.shift();
         elementsarray.push(temp);
         rotate(elementsarray , number-1);
     }
     document.getElementById("rotate").innerHTML = "before rotate the elements are:"+elementsarray;
}
