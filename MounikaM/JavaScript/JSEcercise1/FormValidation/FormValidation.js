function validation(){
    if(document.validationForm.FirstName.value == "") {
        alert("FirstName field is empty please enetr Name");
        documnet.validationForm.FirstName.focus();
        return false;
    }
    var dobformat = document.validationForm.DOB.value;
    if (dobformat == "") {
        alert("empty DOB filed, Please enter DOB");
        document.validationForm.DOB.focus();
        return false;
    }
    var regex = /^(0?[0-9]|[12]\d|3[01])\/(0?[1-9]|1[012])\/\d{4}$/;
    if(!(regex.test(dobformat))) {
        alert("enetr correct format of DOB");
        document.validationForm.DOB.focus();
        return false;
    }
    var empid = parseInt(document.validationForm.EMPID.value);
    if(empid = "" | isNaN(empid)) {
        alert("empty empid filed, Please enter emp id");
        document.validationForm.EMPID.focus();
        return false;
    }
    if(document.validationForm.contactNumber.value.length != 10) {
        alert("invalid Phone number<please enetr valid nu,ber");
        document.validationForm.contactNumber.focus();
        return false;
    }
    var emailformat = document.validationForm.emailId.value;
    var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!(regex.test(emailformat))) {
        alert("enetr correct email id");
        document.validationForm.emailId.focus();
        return false;
    }
    if(emailformat == "") {
        alert("empty email filed, Please enter email");
        document.validationForm.emailId.focus();
        return false;
    }
    return true;
}
