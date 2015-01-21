function checkInterest() {
   var principle= document.getElementById("p").value;
   var time= document.getElementById("t").value;
   var rate= document.getElementById("r").value;
   var interest = (principle * time * rate)/100;
   //document.write("The interest is:"+interest);
   document.getElementById("demo").innerHTML = "The Interest is:"+interest;
}
