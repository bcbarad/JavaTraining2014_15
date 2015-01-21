function formValidation() {
    var register = document.forms["registration"];
    if(firstNameValidate(register) && useridValidate(register) && passValidate(register) && ageValidate(register) && validateDOJ(register)) {
    }
    return false;
}
function firstNameValidate(register) {
    var length = register.firstname.value.length;
    var letters = /^[A-Za-z]+$/;   
    if(length == 0) {
        alert("first name should be required ");
        register.firstname.focus();
        return false;
    }
    if(register.firstname.value.match(letters)) {  
       return true;  
    } else {
       alert('fistname must have alphabet characters only');  
       register.firstname.focus();  
       return false;
    }
    return true;
}
function useridValidate(register) {
   var length = register.userid.value.length;
   var maximum=10,minimum=5;
   if(length ==0) {
        alert( " user id sholud not be  empty");
        register.userid.focus();
        return false;
   } else if(length < minimum || length > maximum ) {
        alert( " user id should be in th range 5 to 10 charecters");
        register.userid.focus();
        return false;
   }
   return true;
} 
function passValidate(register) {
    var length = register.password.value.length;
    var minimum =2;
    if(length ==0) {
        alert( " password should not be empty");
        register.password.focus();
        return false;
   } else if(length < minimum) {
        alert( "password must be 2 or more characters ");
        register.password.focus();
        return false;
   } else if (register.password.value != register.confirmpass.value) {
        alert("password not match");
        register.confirmpass.focus();
        return false;
   }
   return true;
}
function ageValidate(register) {
    var age = parseInt(register.age.value);
    if(!isNumber(age)) {
       alert(" age must be a number");
       register.age.focus();
       return false;
    }
    return true;
}
function validateDOJ(register){
   var dojval = register.doj.value;
   alert(dojval);
   var errorMsg = "";
   re = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
   if(dojval !=" ") { 
        if(regs = dojval.match(re)) { 
            if(regs[1] < 1 || regs[1] > 31) { 
                  errorMsg ="Invalid value for day: " + regs[1]; 
            } else if(regs[2] < 1 || regs[2] > 12) { 
                  errorMsg = "Invalid value for month: " + regs[2]; 
            } else if(regs[3] < minYear || regs[3] > maxYear) { 
                  errorMsg = "Invalid value for year: " + regs[3] + " - must be between " + minYear + " and " + maxYear;
            } 
        } else { 
             errorMsg = "Invalid date format: " + field.value;
        } 
    } else {
          errorMsg = "Empty date not allowed!"; 
    } 
    if(errorMsg != "") { 
         alert(errorMsg); 
         register.doj.focus(); 
         return false;
    }
    return true;
}




























