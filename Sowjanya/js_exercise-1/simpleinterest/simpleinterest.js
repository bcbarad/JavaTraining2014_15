function simpleInterest(principle,time,rate) {
    var si;
    si = (principle*time*rate)/100;
    return si;
}
function calculateSimpleInterest() {
    var principle = prompt("enter the amount to be interested here","1000");
    var time = prompt("enter the time here");
    var rate = prompt("enter the rate percentage here");
    simpleinterest = simpleInterest(principle,time,rate);
    document.write(simpleinterest);
}
