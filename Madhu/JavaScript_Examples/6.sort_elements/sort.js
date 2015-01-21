function sortElements() {
    var numbers = prompt("Please enter the numbers saparated by ,");
    var numarray = numbers.split(",");
    document.getElementById("unsort").innerHTML = "before sort the elements are:"+numarray;
    if (numbers != null) {
        var temp , i, j;
        var sss = [];
        /*for(i=0 ;i < numarray.length ;i++) {
           for(j=i+1; j < numarray.length; j++) {
                if(numarray[i]<numarray[j]) {
                    temp =numarray[i];
                    numarray[i] = numarray[j];
                    numarray[j] = temp;
                }
           }
        }*/
        numarray.sort(function(a, b){return a-b});
        document.getElementById("sort").innerHTML = "after sort the elements are:"+numarray;
    }
    
}
