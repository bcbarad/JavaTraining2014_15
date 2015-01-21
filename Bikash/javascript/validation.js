function validate() {
	if (document.emp.emp_name.value == "") {
		alert("Please fill the employee name");
		document.emp.emp_name.focus();
		return false;
	}
	var empId = parseInt(document.emp.id.value);
	if (empId == "" || isNaN(empId)) {
		alert("Enter Employee ID");
		document.emp.id.value = "";
		document.emp.id.focus();
		return false;
	}
	if (document.emp.phone.value.length != 10) {
		alert("Invalid Phone number");
		document.emp.phone.value = "";
		document.emp.phone.focus();
		return false;
	}
	if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)
			.test(document.emp.email_id.value)) {
		alert("You have entered an invalid email address!")
		document.emp.email_id.focus();
		return false;
	}
	var dob = document.emp.dob.value;
	var pattern = /^(0?[1-9]|[12]\d|3[01])\/(0?[1-9]|1[012])\/([0-9]{4})$/;
	if (dob == null || dob == "" || !pattern.test(dob)) {
		alert("Invalid date of birth");
		document.emp.dob.focus();
		return false;
	}
	prompt("Enter ur name"," bikash");
	return true;

}
