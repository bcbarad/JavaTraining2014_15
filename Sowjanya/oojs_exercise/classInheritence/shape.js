function Shape() {
    this.areaOfTraingle = function(base , height) {
                              return 0.5 * base * height;
                          }
    this.areaOfSquare = function(side) {
                              return side * side;
                          }
}
function getArea() {
    base = document.getElementById("base").value;
    height = document.getElementById("height").value;
    side = document.getElementById("side").value;
}
function ABC() {
   getArea.prototype = new Shape();
   var areaobject = new getArea(); 
   alert(areaobject.areaOfTraingle(base,height));
   alert(areaobject.areaOfSquare(side));
   
}
