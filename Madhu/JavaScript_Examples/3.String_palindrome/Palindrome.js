function checkPalindrome() {
      var input_string= document.getElementById("str").value;
      var rev_string = input_string.split('').reverse().join('');
      if(input_string == rev_string) {
          document.getElementById("rev").innerHTML = "The String  "+ input_string + " is palindrome ";
      } else {
          document.getElementById("rev").innerHTML = "The String  "+ input_string + " is not a palindrome ";
      }
}
