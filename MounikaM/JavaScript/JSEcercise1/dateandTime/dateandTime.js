var time = new Date();
var htmlelement = "<p>  Time in UTC : "+time.toUTCString() + "</p>";
htmlelement += "<p> Local Time is : " +time.toLocaleTimeString()+"</p>";
htmlelement += "<p>Local Date is : " +time.toLocaleDateString()+"</p>";
document.write(htmlelement);
