function Shape() {
    this.squareArea = function(side) {
         return side * side;
    }
    this.squareCube = function(side) {
        return side * side * side;
    }
}
function getSquareSide() {
    a = parseInt(document.getElementById("side").value);
}
function inherit() {
    getSquareSide.prototype = new Shape();
    var sideObj = new getSquareSide();
    document.getElementById("area").innerHTML="area of the square is:"+sideObj.squareArea(a);
    document.getElementById("cube").innerHTML="cube of the square is:"+sideObj.squareCube(a);
}
