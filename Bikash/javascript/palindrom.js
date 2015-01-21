function isPalindrom() {
	var isPalindrom=true;
	var str=document.getElementById("str").value;
    var len = str.length;
    for ( var i = 0; i < len/2; i++ ) {
        if (str[i] !== str[len - 1 - i]) {
        	isPalindrom=false;
        }
    }
    if(isPalindrom){
    	alert(str+" is palindrom");
    }else {
		alert(str+" is not palindrom");
	}
}