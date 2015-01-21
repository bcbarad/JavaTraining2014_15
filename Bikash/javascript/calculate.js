function calculate() {
	var principal = parseInt(document.getElementById("p").value);
	var rateOfInterest=parseInt(document.getElementById("r").value);
	var time=parseInt(document.getElementById("t").value);
	alert("Simple interest of "+principal+" for "+time+" with "+rateOfInterest+" interest rate is:"+principal*time*rateOfInterest/100);
	
}
