function Factory() {
    this.preparation = function (type) {
        var flavour;
        if (type === "blackForest") {
            flavour = new BlackForest();
        } else if (type === "blueBerry") {
            flavour = new BlueBerry();
        } else if (type === "litchiGateaux") {
            flavour = new LitchiGateaux();
        }
        return type;
    };
}

var BlackForest = function() {
    var msg = "---BlackForest Recipe---" + "\n";
    msg += "Sieve together Maida and Cocoa powder" + "\n";
    msg += "Add Milk and Vanilla essence" + "\n";
    msg += "Top with Whipped Cream and Cherries" + "\n";
    msg += "Chill and Serve";
    alert(msg);
}
var BlueBerry = function() {
    var msg = "---BlueBerry Recipe---" + "\n";
    msg += "First prepare Flour and Baking powder mixture" + "\n";
    msg += "Add Milk and Egg yolks" + "\n";
    msg += "Coat Berries" + "\n";
    msg += "Bake for 50 minutes" + "\n";
    alert(msg);
}
var LitchiGateaux = function() {
    var msg = "---LitchiGateaux Recipe---" + "\n";
    msg += "Take some fresh Litchies" + "\n";
    msg += "Wash them and Grind for 5 minutes" + "\n";
    msg += "Put some groundnuts and bake for 45 minutes" + "\n";
    alert(msg);
}

function run() {
    var cake = document.getElementById("cake").value;
    var factory = new Factory();
    var cakeObj = factory.preparation(cake);
    //cakeObj.Factory();
}
