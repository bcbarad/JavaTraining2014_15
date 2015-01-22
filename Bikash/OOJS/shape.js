function Shape(x, y) {
    this.x= x;
    this.y= y;
}
function showShapeProperties(){
	var shape=new Shape(10,20);
	document.getElementById("demo").innerHTML =
		"The properties of Shape class are: X="+shape.x + " Y="+shape.y;
	
}