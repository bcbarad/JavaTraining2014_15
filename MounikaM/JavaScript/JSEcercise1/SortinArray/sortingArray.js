
var sortingArray = new Array();

function calsorting() {
    sortingArray = document.form1.addnumbers.value;
    sortingArray = sortingArray.split(",");
    var typeOrder = document.form1.sortingorder.value;
    if (typeOrder == "ASC") {
        for (var i = 0; i < sortingArray.length-1; i++) {
            for (var j = i+1; j < sortingArray.length; j++) {
                if(sortingArray[i]>sortingArray[j]){
                    var temp=sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j]=temp;
                }
            }
        }
    }else if(typeOrder == "DSC"){
        for (var i = 0; i < sortingArray.length-1; i++) {
            for (var j = i+1; j < sortingArray.length; j++) {
                if(sortingArray[i]<sortingArray[j]){
                    var temp=sortingArray[i];
                    sortingArray[i]=sortingArray[j];
                    sortingArray[j]=temp;
                }
            }
        }
    }else{
        alert("Enter the sorting type properly");
    }
    alert(sortingArray);
}



