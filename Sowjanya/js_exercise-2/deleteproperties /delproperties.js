function deleteProperties() {
    //employee object creation with the properties
    var student = {name:"abcd",
                    sclass:"ssc",
                    rollno:45 
                  };
    document.write("the student properties initially <br>");
    document.write("name---sclass---rollno" + "<br>");
    document.write(student.name + "---" + student.sclass + "---" + student.rollno + "<br>");
    delete student.rollno;
    alert("after deleting rollno property from the student object");
    //as rollno property deleted and trying to access it shows undefined
    document.write(student.name + "---" + student.sclass + "---" + student.rollno + "<br>");
           
}
