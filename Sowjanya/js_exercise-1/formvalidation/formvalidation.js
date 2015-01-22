function formValidation(form) {
    if (validateFirstName(form) && validateLastName(form) && validateEmail(form) && validatePassword(form) && validateAge(form) && validateDateOfBirth(form)) {
        alert("u entered all fields correctly");
    }
}
function validateFirstName(form) {
    if (form.firstname.value == "") {
        alert("Firstname cannot be empty");
        form.firstname.focus(); 
        return false; 
    } 
    re = /^[A-Za-z0-9 ]{3,20}$/; 
    if (!re.test(form.firstname.value)) { 
        alert("name must contain only letters, numbers and underscores!"); 
        form.firstname.focus(); 
        return false; 
    }
    //alert("u entered the Firstname in correct format");
    return true;
}
function validateLastName(form) {
    if (form.lastname.value == "") {
        alert("Lastname cannot be empty");
        form.lastname.focus(); 
        return false; 
    } 
    re = /^[A-Za-z0-9 ]{3,20}$/; 
    if (!re.test(form.lastname.value)) { 
        alert("name must contain only letters, numbers and underscores!"); 
        form.lastname.focus(); 
        return false; 
    }
    validateEmail(form);
    //alert("u entered the Lastname in correct format");
    return true;
}
function validateEmail(form) {
    var email = form.email.value;
    var atposition = email.indexOf("@");
    var dotposition = email.lastIndexOf(".");
    if (atposition < 1 || dotposition < atposition + 2 || dotposition + 2 >= email.length) {
        alert("Not a valid e-mail address");
        form.email.focus();
        return false;
    }
    //alert("u entered the email in correct format");
    return true;
}
function validatePassword(form) {
    if (form.password.value != "") {
	if (form.password.value.length < 6) {
            alert("Error: Password must contain at least six characters!");
	    form.password.focus(); 
	    return false;
	} 
	var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
        if (!re.test(form.password.value)) {
	    alert("Error:please enter password with the combinantion of smalls, caps, special characters and numbers");
            form.password.focus(); 
            return false;
        }
    }
    else { 
        alert("Error: Please check that you've entered and confirmed your password!"); 
        form.password.focus();
        return false; 
    } 
    //alert("u entered the password correctly");
    return true; 
}
function validateDateOfBirth(form) {
    var pattern = /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
    var dateofbirth = form.dateofbirth.value;
    if (!pattern.test(dateofbirth)) {
        alert("u entered date of birth incorrect format ");
        form.dateofbirth.focus();
        return false;
    } 
    return true;
}
function validateAge(form) {
    var age = form.age.value;
    var pattern = /^ *[0-9]+ *$/;
    if(age == "") { 
         alert("please enter the age ");
         form.age.focus();
         return false;
    } else if (!pattern.test(age)) {
        alert("please enter the age in numbers only");
        form.age.focus();
        return false;
    } else {
        if((age < 0) || (age > 100)){
        alert("please enter the age in between 1 to 100");
        return false;
       }
    }
    //alert("u entered the age in correct format");
    return true;
}

