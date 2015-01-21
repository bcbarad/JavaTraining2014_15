function sorting(){
	var numbers=(document.getElementById("numbers").value).split(",");
	var sortingType=document.getElementById("sortingtype").value;
	if(sortingType=="asc"){
		for (var int = 0; int < numbers.length-1; int++) {
			for (var int2 = int+1; int2 < numbers.length; int2++) {
				if(numbers[int]>numbers[int2]){
					var temp=numbers[int];
					numbers[int]=numbers[int2];
					numbers[int2]=temp;
				}//if
			}//for
		}//for
	}else if(sortingType=="dsc"){
		for (var int = 0; int < numbers.length-1; int++) {
			for (var int2 = int+1; int2 < numbers.length; int2++) {
				if(numbers[int]<numbers[int2]){
					var temp=numbers[int];
					numbers[int]=numbers[int2];
					numbers[int2]=temp;
				}//if
			}//for
		}//for
	}else{
		alert("Enter the sorting type properly");
	}
	alert(numbers);
}// function
