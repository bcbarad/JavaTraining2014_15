var myArray = new Array();
function myButtonClick(){
    var myTb = document.getElementById("textBox1");
    myArray.push(myTb.value);
    myTb.value = ""; // reset the textbox
}
function myViewAllButtonClick(){
    //will accept the n value
    var n = document.getElementById("textBox2").value;
    var len = myArray.length;
    // rotating the array
    var i;
    for(i = 0; i < n; i++ ) {
        myArray.unshift(myArray.pop());
        alert(myArray);
    }
}
