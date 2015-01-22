function studentFactory(name, age, sclass) {
	var o = new Object();
	o.name = name;
	o.age = age;
	o.sclass = sclass;
	o.sayName = function() {
		return this.name;
	};
	return o;
}
function run() {
	var student1 = new studentFactory("Bikash", 24, "MCA");
	var student2 = new studentFactory("sasanka", 23, "MCA");
	alert("First Student Name: "+student1.name+" Age: "+student1.age+" Class: "+student1.sclass);
	alert("Second Student Name: "+student2.sayName()+" Age: "+student2.age+" Class: "+student2.sclass);
}