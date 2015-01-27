function factoryObject() {
  this.getVehicleObj = function(type) { 
    var obj;
    if(type == "Car") {
       obj = new Car();
    } else if(type == "Bus") {
       obj = new Bus();
    } else if(type == "Bike") {
       obj = new Bike();
    } 
    return obj;
  };
}
var Car = function () {
             this.travel = function () {
                       //document.getElementById("msg").innerHTML="You wants to travel by Car";
                       alert("You wants to travel by Car");
                       }
}
var Bus = function () {
             this.travel = function () {
                       //document.getElementById("msg").innerHTML="You wants to travel by Bus";
                       alert("You wants to travel by Bus");
                       }
}
var Bike = function () {
             this.travel = function () {
                       //document.getElementById("msg").innerHTML="You wants to travel by Bike";
                        alert("You wants to travel by Bike");
                       }
}
function run() {
    var type = document.getElementById("vehicle").value;
    var factory = new factoryObject();
    var vehicleObj = factory.getVehicleObj(type);
    vehicleObj.travel();
}
