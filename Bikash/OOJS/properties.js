function showProperties(){
	var book = new Object();   // Create the object
    book.subject = "Professional javascript for webdevelopers"; // Assign properties to the object
    book.author  = "Nicholas";
    document.write("Book name is : " + book.subject + "<br>");
    document.write("Book author is : " + book.author + "<br>");
}