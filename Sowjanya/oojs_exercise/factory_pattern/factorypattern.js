function FactoryPattern() {
    this.createShape = function(type) {
        var shapes;
        if (type == "circle") {
             shapes = new Circle();
        } else if (type == "square") {
             shapes = new Square(); 
        }
        shapes.type = type;
        shapes.display = function() {
           log.add(this.type + "cretaed")
           log.add(this.type +  " having " + this.corners + " corners ");
        }
        return shapes;
    }
}
var Circle = function () {
    this.corners = "0";
};
var Square = function () {
    this.corners = "4";
};

var log = (function () {
var log = "";
 
    return {
        add: function (msg) { log += msg + "\n"; },
        show: function () { alert(log); log = ""; }
    }
})();
function myFunction() {
    var shapes = [];
    var factory = new FactoryPattern();
    var i;
    shapes.push(factory.createShape("square"));
    shapes.push(factory.createShape("circle"));
    for (i = 0; i < shapes.length ; i++) {
        shapes[i].display();
    }
    log.show();
}
