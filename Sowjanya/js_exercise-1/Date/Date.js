function currentDate() {
   var date = new Date();
   var day = date.getDate();
   var month = date.getMonth();
   var year = date.getFullYear();
   document.write("Today's date is ");
   document.write(day + "/" + month + "/" + year);
}
