function getProperties() {
    var student = { firstname:"Madhu",
                    lastname:"swarna",
                    empid:7074, 
                    department:"SD", 
                    project:"UTMS" };
    var x ;
    var propertietxt =" ";
    var valuetxt=" ";
    for ( x in student) {
        propertietxt += x+" ";
        valuetxt += student[x]+"  ";
    }
    document.getElementById("properties").innerHTML = propertietxt+"<br>"+valuetxt;
}
