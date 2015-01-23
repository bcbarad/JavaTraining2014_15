function getProperties() {
    var student = { firstname:"Madhu",
                    lastname:"swarna",
                    empid:7074, 
                    department:"SD", 
                    project:"UTMS" };
    var x ;
    var value1txt =" ";
    var valuetxt=" ";
    for ( x in student) {
        valuetxt += student[x]+"  ";
    }
    delete student.empid;
    for ( x in student) {
        value1txt += student[x]+"  ";
    }
    document.getElementById("properties").innerHTML = "before delete the empid the properties: "+valuetxt+"<br>  after delete the empid the properties: "+value1txt;
}
