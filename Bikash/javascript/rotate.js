var elements;
function readArrayElements() {
	elements = prompt("Enter the array elements", "1,5,7,6");
	alert("The array elements are " + elements);
}
function rotateArray() {
	if (elements == null) {
		alert("Enter the ayyar elements first");
	} else if (elements.length != 0) {
		var noOfRotate = parseInt(prompt("Enter the rotation number ", 1));
		if (!isNaN(noOfRotate)) {
			elements1 = elements.split(",");
			if (elements1.length >= noOfRotate) {
				for (var i = 1; i <= noOfRotate; i++) {
					var temp = elements1[elements1.length - 1];
					for (var int = elements1.length - 1; int > 0; int--) {
						elements1[int] = elements1[int - 1];
					}
					elements1[int] = temp;
				}
				alert("Before rotate the array is " + elements
						+ "\n After rotate the array is " + elements1);
			}

		}

	}
}