
function inherits(childClass, parentClass) {
  childClass.prototype = new parentClass();
  childClass.prototype.constructor = childClass;
}

function Shape() {
  // No implementation.
}

Shape.prototype.getSize = function() {
  // No implementation.
};
 
function Box(width, height) {
  Shape.call(this);

  this.width_ = width;

  this.height_ = height;
}
inherits(Box, Shape);

Box.prototype.getWidth = function() {
  return this.width_;
};

Box.prototype.getHeight = function() {
  return this.height_;
};
 
 

Box.prototype.getSize = function() {
  return this.height_ * this.width_;
};
 

function Cube(width, height, depth) {
  Box.call(this, width, height);

  this.depth_ = depth;
}
inherits(Cube, Box);
 

Cube.prototype.getDepth = function() {
  return this.depth_;
};
 
 
Cube.prototype.getSize = function() {
  return this.depth_ +"  "+ this.getHeight() +" "+ this.getWidth();
};
 
var cube = new Cube(3, 6, 9);
document.write(cube.getSize().toString());