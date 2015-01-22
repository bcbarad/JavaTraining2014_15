function shape() {
     this.circleArea = function (radius) {
                            return Math.PI * radius * radius;
                       }
     this.rectangleArea = function (len , breadth) {
                             return len * breadth;
                          }
}
function getRectArea() {
       len = parseInt(document.getElementById("len").value);
       breadth = parseInt(document.getElementById("bred").value);
}
function getCircleArea() {
       radius = parseFloat(document.getElementById("radius").value);
}
function x() {
       getRectArea.prototype = new shape();
       getCircleArea.prototype = new shape();
       var rectobj = new getRectArea();
       document.getElementById("area").innerHTML="area of the recangle is:"+rectobj.rectangleArea(len , breadth);
       var circleobj = new getCircleArea();
       document.getElementById("area1").innerHTML="area of the circle is:"+circleobj.circleArea(radius); 
}   

