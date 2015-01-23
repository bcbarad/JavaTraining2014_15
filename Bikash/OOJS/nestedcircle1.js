var noOfCircles = 10;
	for (var start = noOfCircles * 10; start >= 0; start = start - 10) {
		var c = document.getElementById("myCanvas");
		var ctx = c.getContext("2d");
		ctx.beginPath();
		ctx.arc(150, 150, start, 0, 2 * Math.PI);
		ctx.stroke();
	}
