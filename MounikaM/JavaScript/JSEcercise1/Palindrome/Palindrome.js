function checkPalindrome(){
    var str = document.palindromeForm.String.value;
    var revString = str.split("");
    revString = revString.reverse();
    var reverseString = revString.join("");
    if ( str==reverseString) {
        alert(str+" is Palindrome");
    }
    else {
        alert(str+" is not Palindrome");
    }
}
