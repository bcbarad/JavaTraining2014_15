var Singleton = (function () {
var instance;   
function createInstance() {
    var object = new Object("I am the instance");
    return object;
}
     
return {
    getInstance: function () {
        if (!instance) {
        instance = createInstance();
        }
        return instance;
    }
};
})();
     
function myFunction() {
     
var instance1 = Singleton.getInstance();
var instance2 = Singleton.getInstance();
var instance3 = Singleton.getInstance();
 //here instances created only once
  alert("Same instance : " + (instance2 === instance3));
 }
