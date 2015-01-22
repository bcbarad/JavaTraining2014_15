function calculatePalindrome() {
    var reverseString = "";
    var string = prompt("enter the string to check palindrome or not" , "word or sentense");
    var i = string.length;
    for (var j = i; j >= 0; j--) {
        reverseString = reverseString+string.charAt(j);
    }
    if (string == reverseString) {
        alert(string + " is Palindrome");
    } else {
        alert(string + " is not a Palindrome");
    }
}
