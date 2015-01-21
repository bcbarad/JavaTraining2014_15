// Set up!
var a_canvas = document.getElementById("a");
var context = a_canvas.getContext("2d");

// Draw the face
context.fillStyle = "yellow";
context.beginPath();
context.arc(95, 85, 40, 0, 2*Math.PI);
context.closePath();
context.fill();
context.lineWidth = 2;
context.stroke();
context.fillStyle = "black";

// Draw the left eye
context.beginPath();
context.arc(75, 75, 5, 0, 2*Math.PI);
context.closePath();
context.fill();

// Draw the right eye
context.beginPath();
context.arc(114, 75, 5, 0, 2*Math.PI);
context.closePath();
context.fill();

//draw another circle
context.beginPath();
context.arc(97 , 100 , 10, 0 , 2*Math.PI);
context.closePath();
context.fill();

// Write "Hello, World!"
context.font = "30px Garamond";
context.fillText("Hello, World!",15,175);
