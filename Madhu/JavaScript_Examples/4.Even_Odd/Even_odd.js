function printEvenOdd() {
   var number = parseInt(document.even.num.value);
   var i;
   var even = new Array();
   var odd = new Array();
   for( i=1 ; i <= number; i++) {
      if( (i % 2) == 0) {
         even.push(i);
      } else {
         odd.push(i);
      }
   }
   document.getElementById("even").innerHTML ="Even Numbers are: " + even +" <br> Odd numbers are: " + odd;
}
