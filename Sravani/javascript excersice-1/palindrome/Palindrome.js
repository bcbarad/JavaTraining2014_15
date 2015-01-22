function funpal() {
    var str = document.gud.pal.value;
    var str1 = str;
    var reverse = " ";
    var length = str.length;
    var i;
    for (i = length - 1 ; i >= 0 ; i--) {
        reverse = str.split("").reverse().join("");
    }
    if(str1 == reverse) {
        str = str1 + "is a palindrome";
    } else {
        str = str1 + " is not a palindrome";
    }
    alert(str);
}

