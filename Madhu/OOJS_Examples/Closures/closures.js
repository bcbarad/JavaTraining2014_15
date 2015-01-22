var multiple = (function () {
    var counter = 1;
    return function () {
         return counter *= 2;}
    })();
function getMultiple() {
   document.getElementById("m").innerHTML=multiple();
}
