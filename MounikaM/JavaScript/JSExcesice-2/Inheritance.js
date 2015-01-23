function inheritanceDemo() {
var Shape = function() {};
Shape.prototype.initialize = function(shapename,legth,height){
this.shapename = shapename;
this.legth = legth;
this.height = height;
}
var area;
var Square = function() {};
Square.prototype = new Shape();
Square.prototype.getArea = function() {
area = this.legth * this.height;
alert (this.shapename + " has area " + area);
}
var square1 = new Square();
square1.initialize("square", 10,10);
square1.getArea();
}




