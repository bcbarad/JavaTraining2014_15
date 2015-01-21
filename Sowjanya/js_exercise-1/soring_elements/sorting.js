function sortAscendingOrder(form){
    var elements = form.elements.value;
    var values = elements.split(","); 
    var temp;
    alert(values.length);
    if (values != "") {
        values.sort(function(a, b){return a-b});  
        document.write(values);
    }
    else {
        alert("enter the elements first");
    } 
}
function sortDescendingOrder(form){
    var elements = form.elements.value;
    var values = elements.split(","); 
    var temp;
    if (values != "") {
        values.sort(function(a, b){return b-a});  
        document.write(values);
    }
    else {
        alert("enter the elements first");
    } 
}



