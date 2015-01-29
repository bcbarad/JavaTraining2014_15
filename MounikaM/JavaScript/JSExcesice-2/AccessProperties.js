function retriveObjectProperties() {

    var employee = {name : "EMP",role :"devoloper",empid : 7076,greeting:function(){ alert("hello" +this.name);} };

    var keys = new Array();
    for (var k in employee) {
        keys.push(k);
    }
    alert("emp properties are :" +keys);
}
