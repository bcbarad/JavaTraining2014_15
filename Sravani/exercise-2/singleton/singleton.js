    var Singleton = (function () {
    var instance;
     
    function createInstance() {
          var name = "sravani";
          /*var reverse = " ";
    var length = str.length;
    var i;
    for (i = length - 1 ; i >= 0 ; i--) {
        reverse = str.split("").reverse().join("");
    }*/
    return name;
    }
     
    return {
    getInstance: function () {
    if (!instance) {
    instance = createInstance();
    }
    return instance;
    }
    };
    })();
     
    function run() {
     
    var instance1 = Singleton.getInstance();
    var instance2 = Singleton.getInstance();
     
    alert(instance1 + " " + instance2);
    }
