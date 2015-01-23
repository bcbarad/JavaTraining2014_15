var Singleton = (function () {
   var instance; 
    function createWindow() {
          return window.open("http://www.gmail.com" , "_blank",  "width=800 , height=800");
    }   
    return {
    getInstance: function () {
    if (!instance) {
    instance = createWindow();
    }
    return instance;
    }
    };
})();
     
function run() {
    inst = Singleton.getInstance();
}
