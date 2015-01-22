function evenOddNumbers(){
    var mini = Number(document.form1.minimum.value);
    var maxi = Number(document.form1.maximum.value);
    var evenArray = new Array();
    var oddArray = new Array();
    var oddIndex = 0;
    var evenIndex = 0;
    if ( (mini < 1 | maxi > 999) | (mini>maxi)) {
        alert(" Sorry !! " +mini + " and " + maxi+ " not in (1- 999) range or minimum value higher than maximu value");
    }
    else {
        for ( var i = mini; i < maxi ; i++) {
            if ( i % 2 == 0 ) {
                evenArray[evenIndex] = i;
                evenIndex += 1;
            }
            else {
                oddArray[oddIndex] = i;
                oddIndex += 1;
            }
        }

        evenArray = evenArray.join(",");
        oddArray= oddArray.join(",");
        alert (" even numbers between " + mini + " and " +maxi+ " is " + evenArray); 
        alert (" odd numbers between " + mini + " and " +maxi+ " is " + oddArray);
    }
}

