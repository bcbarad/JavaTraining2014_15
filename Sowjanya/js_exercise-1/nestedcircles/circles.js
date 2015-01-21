function nestedCircles() {
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
 
        ctx.beginPath();
        ctx.arc(100,100,50,0,2*Math.PI,true);
	ctx.fillStyle = "red";
	ctx.fill();
	ctx.lineWidth = 5;
	ctx.stroke();
	ctx.strokeStyle = '#003300';
	ctx.beginPath();
	ctx.arc(100,30,20,0,2*Math.PI,true);
	ctx.stroke();
        ctx.beginPath();
        ctx.arc(80,120,30,0,2*Math.PI,true);
	ctx.fillStyle = "black";
	ctx.fill();
	ctx.stroke();
}
