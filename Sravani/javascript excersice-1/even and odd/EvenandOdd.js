function evenodd() {
    var r1 = parseInt(document.eo.range1.value);
    var r2 = parseInt(document.eo.range2.value);
    var even = new Array();
    var odd = new Array();
    if(r1 < 1 || r2 >= 999) {
        var str = "range should be only between 1 and 999";
        alert(str);
    }
    else {
        var i , rem;
        for(i = r1; i <= r2; i++) {
            rem = i%2;
            if(rem == 0) {
                even.push(i);
            } else {
                odd.push(i);
            }
        }
        var msg = "even numbers: " + even.join(",") + "odd numbers: " + odd.join(",");
    }
    alert(msg);
}
