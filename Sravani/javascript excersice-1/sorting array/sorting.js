var myArray = new Array();

function myButtonClick(){
    var myTb = document.getElementById("textBox1");
    myArray.push(myTb.value);
    myTb.value = ""; // reset the textbox
} 
function myViewAllButtonClick(){
   // will create a string of myArray's values, seperated by new line character
   myArray.sort(function(a , b){return a-b});
   var msg = myArray.join("\n");
   // will show the user all of the values in a modal alert
   alert(msg);
}
