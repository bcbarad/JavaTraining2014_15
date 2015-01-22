function createObject(){
	student = {
	    name:"Bikash",
	    sclass:"MCA",
	    rollno: 17
	};
	document.getElementById("demo").innerHTML =
		"Before delete the properties are name: "+student.name + ", class:  " + student.sclass + ", rollno: "+student.rollno;
}
function deleteRollNo(){
	delete student.rollno;
	document.getElementById("demo").innerHTML =
		"After delete the rollno Name:"+student.name + " Class: " + student.sclass + " Roll no: "+student.rollno;
}