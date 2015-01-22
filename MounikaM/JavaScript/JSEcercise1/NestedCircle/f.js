function nestedCircle() {
var circle=document.getElementById("mycanvas");
if(circle.getContext) {
var ctx = circle.getContext("2d");
ctx.beginPath();
ctx.arc(100,50,40,0,2*Math.PI,false);
ctx.fillStyle="red";
ctx.fill();
ctx.arc(100,50,30,0,2*Math.PI,false);
ctx.arc(100,50,20,0,2*Math.PI,false);
ctx.stroke();
}
}
