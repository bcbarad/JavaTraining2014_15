function calSimpleIntrest(){
    var p = document.simpleIntrestForm.Principle.value;
    var r = document.simpleIntrestForm.Rate.value;
    var t = document.simpleIntrestForm.Time.value;
    var result = p * t * r;
    result = result/100;

    alert("Simple Intrest for Principle" + p + " Rate " + r + "Time" +t + "is : " + result);
}
