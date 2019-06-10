var app=angular.module("helloworld",[]);

app.controller("c1",["$scope",function(c){
    
    c.name="anurag asthana";
    c.sex="male"
    c.an=function(){
        return "anurag asthana is sexy"
    }
    
    
}]);