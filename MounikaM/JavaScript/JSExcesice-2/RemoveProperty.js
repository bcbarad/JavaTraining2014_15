function removeObjectProperty() {

    var employee = {name : "EMP",role :"devoloper",empid : 7076,greeting:function(){ alert("hello" +this.name);} };

    var keys = new Array();
    var keys2 = new Array();
    dispayProperties(keys,employee)
        alert("emp properties before deleting role Property :" +keys);
    delete employee.role;
    dispayProperties(keys2,employee)
        alert("emp properties after deleting Role Property :" +keys2-);

}
function dispayProperties(keys2,employee) {
    for (var k in employee) {
        keys2.push(k);
    }
}
