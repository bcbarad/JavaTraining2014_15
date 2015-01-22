function popup() {
    var p = document.intrest.principle.value;
    var r = document.intrest.rate.value;
    var t = document.intrest.time.value;
    var si = (p*t*r)/100;
    alert(si);
}
