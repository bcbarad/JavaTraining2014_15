function rotateArray(form) {
    var array = form.elements.value;
    var arrayelements = array.split(",");
    var rotatevalue = form.roatatingnumber.value;
    if ((arrayelements != "") && (rotatevalue != "")) {
        if (rotatevalue > 0) {
            document.write("array elements before rotating <br>" + arrayelements + "<br>");
            document.write("");
            for (var i = 0; i<rotatevalue; i++) {
                var temp  = arrayelements.shift();
                arrayelements.push(temp);
            }
            document.write("array elements after rotating " + rotatevalue + " times <br> " + arrayelements + "<br>");
        } 
        else {
            document.write("array elements before rotating <br>" + arrayelements + "<br>");
            document.write("");
            for (var i = 0; i>rotatevalue; i--) {
                var temp  = arrayelements.pop();
                arrayelements.unshift(temp);
            }
            document.write("array elements after rotating " + rotatevalue + " times <br> " + arrayelements + "<br>");
        }
    }
    else {
        alert("enter the elements and rotatevalue");
    } 
}
