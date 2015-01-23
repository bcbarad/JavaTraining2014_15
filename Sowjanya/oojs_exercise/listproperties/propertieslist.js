function listProperties() {
    //employee object creation with the properties
    var employee = { emp_id:10541,
                     emp_name:"abcdf",
                     emp_basesal:10000,
                     emp_pf:1000,
                     //method is stored in properties as function definition.
                     emptotalsal:function() {
                                     return (parseInt(this.emp_basesal) + parseInt(this.emp_pf));
                                 } 
                   }; 
    //display the employee object properties       
    document.write(" employee id is : " + employee.emp_id + "<br>");
    document.write(" employee name is : " + employee["emp_name"] + "<br>");
    document.write(" employee basic salary is : " + employee["emp_basesal"] + "<br>");
    document.write(" employee pf cuttings are : " + employee.emp_pf + "<br>");
    document.write(" employee total salary is : " + employee.emptotalsal() + "<br>");
    //adding new property to the employee object
    employee.emp_age = 22;
    document.write(" employee age is : " + employee.emp_age + "<br>");
}
