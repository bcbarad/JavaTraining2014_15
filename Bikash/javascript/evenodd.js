function showEnenOddNumbers() {
	var start = parseInt(document.getElementById("s").value);
	var end = parseInt(document.getElementById("e").value);
	var even = new Array();
	var odd = new Array();
	if (start >= 1 && end <= 999) {
		for (var int = start; int < end; int++) {
			if (int % 2 == 0) {
				even.push(int);
			} else {
				odd.push(int);
			}
		}
		alert("Even numbers between " + start + " and " + end + " are: " + even);
		alert("Odd numbers between " + start + " and " + end + " are: " + odd);
	}else {
		alert("Enter the range between 1 to 999");
	}
}