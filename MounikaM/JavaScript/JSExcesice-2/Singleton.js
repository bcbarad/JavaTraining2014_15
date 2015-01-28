var Singleton = (function() {
var instance;
createInstance = function(val) {
var x = val - 1;

return x;
}
return {
 getInstance: function(val) {
 if(!instance) {
  instance = createInstance(val);
 }
 return instance;
}
};
})();
function run() {
var val = 10;
var c = 12;
var instance1 = Singleton.getInstance(val);
var instance2 = Singleton.getInstance(c);
if("Same instance? " + (instance1 === instance2)){
alert (" Both instances are same");
}
 
alert(instance1 + " " +instance2);
}

