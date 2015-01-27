function ECE(typeofBranch){
this.branchCode = "B12";
this.display = function() {
 alert(typeofBranch + " ranked has " + this.branchCode);
};
}
function CSE(typeofBranch){
this.branchCode = "B10";
this.display = function() {
 alert(typeofBranch + " ranked has " + this.branchCode);
};
}
function IT(typeofBranch){
this.branchCode = "B11";
this.display = function() {
 alert(typeofBranch + " ranked has " + this.branchCode);
};
}
function EIE(typeofBranch){
this.branchCode = "B09";
this.display = function() {
 alert(typeofBranch + " ranked has " + this.branchCode);
};
}

function College(collegeName) {
this.collegeName = collegeName;
var branch;
this.branches = function(typeofBranch) {
if (typeofBranch == "Ece") {
  branch = new ECE(typeofBranch);
}
else if(typeofBranch == "Cse"){
  branch = new  CSE(typeofBranch);
}
else if(typeofBranch == "Eie"){
  branch = new EIE(typeofBranch);
}
else if (typeofBranch == "It"){
 branch = new It();
}
return branch;
}
}
function run() {
var clg = new College("CVR");
var br = clg.branches("Cse");
br.display();
}


