    var Singleton = (function () {
    var instance;
     
    function createInstance(name) {
          //var name = 'sravani';
          var Reverse= name.split("").reverse().join("");
    return Reverse;
    }
     
    return {
    getInstance: function (str) {
    if (!instance) {
    
    instance = createInstance(str);
    }
    return instance;
    }
    };
    })();
     
    function run() {
    var str = document.getElementById("str").value; 
    var instance1 = Singleton.getInstance(str);
    var instance2 = Singleton.getInstance(str);
     
    alert(instance1 + " " + instance2);
    }
