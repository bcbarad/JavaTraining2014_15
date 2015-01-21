function calculate() {
    var highestnumber = 999
    var leastnumber = 1;
    var number = prompt("enter a number");
    if ((number > leastnumber) && (number < highestnumber)) {
        evenOddDisplay(number , highestnumber);
    }
    else {
        alert("enter the number that ranges in 1 to 999");
    }
}
function evenOddDisplay(num , highnum) {
    var myEvenArray = new Array();
    var myOddArray = new Array();
    var count = highnum - num ;
    //document.write("the even odd numbers up to" + highnum + "from" + num);
    document.write("<br>");
    for (var i = 0; i<=count; i++) {
       if (num % 2 == 0) {
           myEvenArray[i] = num;
       }
       if (num % 2 == 1) {
           myOddArray[i] = num;
       }
       num++; 
    }
    document.write("even numbers are : ");
    document.write(myEvenArray); 
    document.write("<br>");
    document.write("odd numbers are : ");
    document.write(myOddArray);    
}





