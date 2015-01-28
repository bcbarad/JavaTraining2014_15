function makeFunc() {
  var name = "Demo On Closure";
  function displayName() {
    alert(name);
  }
  return displayName;
}
function run() {
var myFunc = makeFunc();
myFunc();
//makeFunc.name = "yahoo!!";
//var m = makeFunc();
//m();
}
