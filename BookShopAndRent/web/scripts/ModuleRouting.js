var app=angular.module("helloworld",["ui.router"]).config(function($stateProvider,$urlRouterProvider){
    
    var firstName;
     $urlRouterProvider.otherwise("/home");
 $stateProvider.state("anurag",{
     url:"/anurag",
     templateUrl:'UserRegistration.html'
     
     
 })
 .state("home",{
     url:"/home",
    views:{ 
        '':{templateUrl:'Home.html',//Instead of Home.html use Home.html if any error causes
             controller:'Home'
            },
       'HomePageData@home':{
           templateUrl:'HomeData.html'
          
         
          
       }
//        
   
   }
   
 })
 //show book state
  .state("BookDetails",{
                url: "/bookid:isbn",
                templateUrl: 'BookDetails.html',
                controller: 'ShowBookDetail'
   
   
 })
 
            
            .state("Payment",{
                url:"/orderId:orderid",
                templateUrl:'UserPurchasedBook.html',
                controller:'makePayment'
                
                
            })
 
 //nested views starts here
  .state("userProfileSection",{
     url:"/UserProfile",
    
                views: {
                    '': {templateUrl: 'UserProfile.html',
                 controller:'UserProfile'  //calling servlet from here to get the user details in json object
            
            },
                    'profile-info@userProfileSection': {
                        templateUrl: 'UserProfileView.html'},
                     
                        




                }
                
     
 })
  .state("userProfileSection.manageAddresses",{
     url:"/manageAddress",
    
                views:{
                  'profile-info':{
                      templateUrl:'ManageAddress.html',
                      controller:'userAddress'
                     
                  }  
                 

                }
     
 })
 .state("userProfileSection.savedCards",{
     url:"/PaymentMethods",
    
                views:{
                  'profile-info':{
                      templateUrl:'PaymentMeth.html'
                      
                  }  
       
                }
     
 })
  .state("userProfileSection.ChangePassword",{
     url:"/ChangePassword",
    
                views:{
                  'profile-info':{
                      templateUrl:'ChangePassword.html'
                      
                  }  
       
                }
     
 })
  
     

  //here nested views are ended
 .state("userPurchaseSection",{
     url:"/YourPurchases",
     templateUrl:'UserPurchasedBook.html'
     
     
 })
    .state("userBorrowBooksSection",{
     url:"/BorrowBook",
     templateUrl:'UserBorrowBook.html'
     
     
 })
 //nested viws ended here
    .state("userRentedBooksSection",{
     url:"/UserRentedBook",
     templateUrl:'UserRentedBook.html'
     
     
 })
.state("userWalletSection",{
      url:'/UserWallet',
    templateUrl:'UserWallet.html',
   
     
 })
.state("BuyBook",{
      url:'/BuyBook',
    templateUrl:'TestBuyBook.html'
     
 })

    
    
});






//controller's


///internal module detail working





// below the controller is used to get the user details 


//cart ontroller
//order controller
app.controller("order",['$scope','$http','$window',function($scope,$http,$window){
                 
//               
                    
//                    $window.alert("calling in shipping address");
                     $http({
//                    
                    url:"/BookShopAndRent/GetShippingAddress",
                    method:"get",
//////                  
                }).then(function(result){
                    
//                    $window.alert("ajax success  address section");
//                    var addres=JSON.stringify(result.data.address);
//                     var pincode=JSON.stringify(result.data.pincode);
//                      $window.alert("ajax success");
                      $scope.addresses=result.data;
                    
                    
                    
                },function(result){
                    $window.alert("ajax failed at user Manage address controller");
                    
                });
//                
////               
                
                
            }]);
 app.controller("fetchShippingAddress",['$scope','$http','$window',function($scope,$http,$window){
                 
//               
                    
//                    $window.alert("calling in shipping address");
                     $http({
//                    
                    url:"/BookShopAndRent/GetShippingAddress",
                    method:"get",
//////                  
                }).then(function(result){
                    
//                    $window.alert("ajax success  address section");
//                    var addres=JSON.stringify(result.data.address);
//                     var pincode=JSON.stringify(result.data.pincode);
//                      $window.alert("ajax success");
                      $scope.addresses=result.data;
                    
                    
                    
                },function(result){
                    $window.alert("ajax failed at user Manage address controller");
                    
                });
//                
////               
                
                
            }]);
  app.controller("cart",['$scope','$http','$window',function($scope,$http,$window){
                 
               $scope.cartItem=function(isbn,seller_id){
                    
                    $window.alert("calling"+isbn+seller_id);
                     $http({
//                    
                    url:"/BookShopAndRent/ShoppingCards",
                    method:"get",
//////                    to send data to servlet
                params:{
                       "isbn":isbn,
                       "seller_id":seller_id
                    }
                }).then(function(result){
                    
                    $window.alert("ajax success section");
                   
                      $window.alert("ajax success"+result.err);
                      $scope.status=result.data;
                    
                    
                    
                },function(result){
                    $window.alert("ajax failed at user Manage address controller");
                    
                });
                }
//               
                
                
            }]);
       

app.controller("ShowBookDetail",['$scope','$http','$window','$stateParams',function($scope,$http,$window,$stateParams){
                 var book=this;
//                $scope.UserDetail=function(){
                    
//                    $window.alert("calling");
                     $http({
                    
                    url:"/BookShopAndRent/GetSelectedBook",
                    method:"get",
                 
                    params:
                        {isbn: $stateParams.isbn}
                    
                    
           
                }).then(function(result){
                    
//                    $window.alert("ajax success working"+result.status+result.data);
                    $scope.bookDtls=result.data;
                    
                     
                   
//                      $window.alert("ajax success"+result.data);
                    
                    
                    
                },function(result){
                    $window.alert("some internal error at show Book Detail Controller");
                    
                });
//                }
               
                
                
            }]);
        app.controller("makePayment",['$scope','$http','$window','$stateParams',function($scope,$http,$window,$stateParams){
                
               var pay=this;
               $scope.createTransaction=function(){
                    
                  
                     $http({
                    
                    url:"/BookShopAndRent/MakePayment",
                    method:"post",
                 
                    params:
                        {
                            orderId:$stateParams.orderid
                }
                
                    
                    
           
                }).then(function(result){
                    
                    
                    
                    
                    
                },function(result){
                    $window.alert("some internal error at show makePayment Controller");
                    
                });
                }
               
                
                
            }]);
       

app.controller("UserProfile",['$scope','$http','$window',function($scope,$http,$window){
                 
//                $scope.UserDetail=function(){
                    
//                    $window.alert("calling");
                     $http({
                    
                    url:"/BookShopAndRent/GetUserPersonalInfo",
                    method:"get"
//                    to send data to servlet
//                    param:{
//                        "varaible":$scope.variable
//                    }
                }).then(function(result){
                    
                    
//                    $window.alert("ajax success working");
                     $scope.fName=JSON.parse(JSON.stringify(result.data.firstName));
                       $scope.midName=JSON.parse(JSON.stringify(result.data.midName));
                  $scope.lastName=JSON.parse(JSON.stringify(result.data.lastName));    
                  $scope.gender=JSON.parse(JSON.stringify(result.data.gender)); 
                   $scope.email=JSON.parse(JSON.stringify(result.data.UserId));
                   $scope.mobileNo=JSON.parse(JSON.stringify(result.data.mobileNo));
                   $scope.editGender=JSON.parse(JSON.stringify(result.data.gender));
                $scope.listObj=result.data;
                    
                     
                   
//                      $window.alert("ajax success"+result.data);
                    
                    
                    
                },function(result){
                    $window.alert("ajax failed at User profile controller");
                    
                });
//                }
               
                
                
            }]);
        
          app.controller("login",['$scope','$http','$window',function($scope,$http,$window){
                 
               $scope.logon=function(){
                    
                    $window.alert("calling");
//                     $http({
////                    
//                    url:"/BookShopAndRent/UserLogInStatus",
//                    method:"get"
////////                    to send data to servlet
////////                    param:{
////////                        "varaible":$scope.variable
//////                    }
//                }).then(function(result){
//                    
//                    $window.alert("ajax success nsection");
//                   
//                    
//                    
//                     
//                   
//                      $window.alert("ajax success"+result.data);
//                      $scope.status=result.data;
//                    
//                    
//                    
//                },function(result){
//                    $window.alert("ajax failed at user Manage address controller");
//                    
//                });
                }
//               
                
                
            }]);
        
app.controller("loginchecking",['$scope','$http','$window',function($scope,$http,$window){
                 
               $scope.loginstatus=function(){
                    
//                    $window.alert("calling");
                     $http({
//                    
                    url:"/BookShopAndRent/UserLogInStatus",
                    method:"get"
//////                    to send data to servlet
//////                    param:{
//////                        "varaible":$scope.variable
////                    }
                }).then(function(result){
                    
//                    $window.alert("ajax success nsection");
                   
                    
                     $scope.status=result.data;
                     
                   var loginStatus=JSON.stringify(result.data.error);
//                      $window.alert("ajax success"+loginStatus);
                    
                    
                    
                },function(result){
                    $window.alert("ajax failed at user Manage address controller");
                    
                });
                }
               
                
                
            }]);
        

app.controller("userAddress",['$scope','$http','$window',function($scope,$http,$window){
                 
//               $scope.userAddress=function(){
                    
//                    $window.alert("calling");
                     $http({
//                    
                    url:"/BookShopAndRent/GetUserAddresses",
                    method:"get"
////                    to send data to servlet
////                    param:{
////                        "varaible":$scope.variable
//                    }
                }).then(function(result){
                    
//                    $window.alert("ajax success namage addresses section");
                   
                    
                    
                     
                   
//                      $window.alert("ajax success"+result.data);
                    
                    
                    
                },function(result){
                    $window.alert("ajax failed at user Manage address controller");
                    
                });
//                }
               
                
                
            }]);

//Home Page controller
app.controller("Home",['$scope','$http','$window',function($scope,$http,$window){
                 
//                $scope.UserDetail=function(){
                    
//                    $window.alert("calling");
                     $http({
                    
                    url:"/BookShopAndRent/AllBook",
                    method:"get"
//                    to send data to servlet
//                    param:{
//                        "varaible":$scope.variable
//                    }
                }).then(function(result){
                    
//                    $window.alert("ajax success user wallet"+result.status+result.data);
                    $scope.listObj=result.data;
                    
                     
                   
//                      $window.alert("ajax success"+result.data);
                    
                    
                    
                },function(result){
                    $window.alert("ajax failed at home controller");
                    
                });
//                }
               
                
                
            }]);

app.controller('hideAndShow',function($scope){
    $scope.hideandshow = false;
    $scope.artCat=false;
    $scope.bioraphy = false;
    $scope.bodyCat = false;
    $scope.computerCat = false;
    $scope.cookeryCat = false;
    $scope.dictionariesCat = false;
     $scope.environment = false;
     $scope.fiction = false;
     $scope.history = false;
     
 $scope.$watch('hideandshow',function(){
        $scope.buttonvalue = $scope.hideandshow ? 'Architecture' : 'Architecture';
        $scope.subartcat = $scope.artCat ? 'Art Forms' : 'Art Forms';
        $scope.subartcatbio = $scope.bioraphy? 'Biography & memories' : 'Biography & memories';
        $scope.subartcatbody = $scope.bodyCat ? 'Body & spirit' : 'Body & spirit';
        $scope.subartcatcomputer = $scope.computerCat ? 'Computer and phenomenam' : 'Computer and phenomenam';
        $scope.subartcatcookery = $scope.cookeryCat ? 'cookery food & wine' : 'cookery food & wine';
        $scope.subartcatlanguage = $scope.dictionariesCat ? 'dictionaries & languages' : 'dictionaries & languages';
     $scope.subartcatEnvironment = $scope.environment ? 'Environmental & geography' : 'Environmental & geography';
     $scope.subartcatFiction = $scope.fiction? 'Fiction' : 'Fiction';
     $scope.subartcathistory = $scope.fiction? 'History & Humanaties' : 'History & Humanaties';
     
 })
    
    
});


app.controller('quantityUpdate',function($scope){
    
$scope.bookQuantity=1;

    
});
//add new address controller
app.controller("addAddress",['$scope','$http','$window',function($scope,$http,$window){
                 
                $scope.save=function(address,pincode){
                    
                    var add=address;
                    var pin=pincode;
                    $window.alert("calling "+add+"\n"+pin);
//                     $http({
//                    
//                    url:"/BookShopAndRent/AllBook",
//                    method:"get"
////                    to send data to servlet
////                    param:{
////                        "varaible":$scope.variable
////                    }
//                }).then(function(result){
//                    
////                    $window.alert("ajax success user wallet"+result.status+result.data);
//                    $scope.listObj=result.data;
//                    
//                     
//                   
////                      $window.alert("ajax success"+result.data);
//                    
//                    
//                    
//                },function(result){
//                    $window.alert("ajax failed at add new address controller");
//                    
//                });
                }
               
                
                
            }]);
//order entry controller
app.controller("makeOrder",['$scope','$http','$window',function($scope,$http,$window){
              
        var pin;
                 var add;
                 $scope.quantity=1;
                 var cobj=this;
                $scope.continue=function(isbn,price,sellerId,q){
                  
                    $window.alert("calling"+isbn+"\n"+price+"\n"+sellerId+"\n"+$scope.pin+$scope.add+"\n"+$scope.quantity);
                    
                     $http({
                    
                    url:"/BookShopAndRent/MakeOrder",
                    method:"post",
//                    to send data to servlet
                     params:{
                        isbn:isbn,
                        price:price,
                        sellerId:sellerId,
                        address:$scope.add,
                        pincode:$scope.pin,
                        quantity:$scope.quantity
                        
                         
                     }
                }).then(function(result){
                    
//                var err=JSON.parse(JSON.stringify(result.data.error));
//                    $window.alert("ajax success at make Ordrer controller"+result.status+result.data);
                    $scope.order=result.data;
//                   if (err=='false') {
//                     $window.alert("your Order Was Unsuccessful ");
//                 
//                }
//                    
                     
                   
//                      $window.alert("ajax success"+result.data);
                    
                    
                    
                },function(result){
                    $window.alert("ajax failed at add new address controller");
                    
                });
                }
               
                  $scope.continue2=function(addressName2,selectPincode2){
                  
                    $window.alert(addressName2+selectPincode2);
//                    
                     $scope.pin=selectPincode2;
                   $scope.add=addressName2;   
//                        $http({
//                    
//                    url:"/BookShopAndRent/AllBook",
//                    method:"get"
////                    to send data to servlet
////                    param:{
////                        "varaible":$scope.variable
////                    }
//                }).then(function(result){
//                    
////                    $window.alert("ajax success user wallet"+result.status+result.data);
//                    $scope.listObj=result.data;
//                    
//                     
//                   
////                      $window.alert("ajax success"+result.data);
//                    
//                    
//                    
//                },function(result){
//                    $window.alert("ajax failed at add new address controller");
//                    
//                });

                




                }
               
                
            }]);
        
        
        //update profile controller
        app.controller("updateProfile",['$scope','$http','$window',function($scope,$http,$window){
                 
             $scope.update=function(){
//                    $window.alert($scope.editGender);
//                    $window.alert("calling"+fName+"\n"+midName+"\n"+lastName+"\n"+userId+"\n"+mobileNo+"\n"+editGender);
                     $http({
////                    
                    url:"/BookShopAndRent/UpdatePersonalInfo",
                    method:"get",
//////                    to send data to servlet
                    params:{
                        firstName:$scope.fName,
                        midName:$scope.midName,
                        lastName:$scope.lastName,
                        userId:$scope.email,
                        mobileNo:$scope.mobileNo,
                        gender:$scope.editGender
                         
                     }
                }).then(function(result){
                    var test=JSON.parse(JSON.stringify(result.data.error));
//                    $window.alert("ajax success nsection");
//                    $window.alert("ajax success"+test);
                      $scope.status=result.data;
                    if(test=="success"){
                         $window.alert("you are successfully updated");
                    }
                    
                    
                },function(result){
                    $window.alert("something went wrong try again later");
                    
                });
                }
                  
               
                
                
            }]);
        
        //
//var myApp = angular.module('helloworld', ['ui.router']);
//
//myApp.config(function($stateProvider,$urlRouterProvider) {
//  $urlRouterProvider.otherwise("/home");
//    
//    
//    var home = {
//    name: 'home',
//    url: '/home',
//    templateUrl: 'Home.jsp'
//  }
//
// /* var aboutState = {
//    name: 'about',
//    url: '/about',
//    templateUrl: 'index.jsp'
//  }*/
// var registrationState=
//         {
//     
//     name:'anurag',
//     url:'/anurag',
//     templateUrl: 'UserRegistration.html'
//     
// }
// var userProfileSection={
//     name:'UserProfile',
//     url:'/UserProfile',
//     templateUrl:'UserProfile.html'
//     
//     
// }
// 
// var userPurchaseSection={
//     name:'YourPurchases',
//     url:'/YourPurchases',
//     templateUrl:'UserPurchasedBook.html'
//     
//     
//     
// }
// var userBorrowBooksSection={
//     name:'BorrowBook',
//     url:'/BorrowBook',
//     templateUrl:'UserBorrowBook.html'
// }
//  var userRentedBooksSection={
//     name:'UserRentedBook',
//     url:'/UserRentedBook',
//     templateUrl:'UserRentedBook.html'
// }
//  var userWalletSection={
//      name:'UserWallet',
//      url:'/UserWallet',
//      templateUrl:'UserWallet.html'
//      }
//           
//  $stateProvider.state(home);
//  //$stateProvider.state(aboutState);
//  $stateProvider.state(registrationState);
//  $stateProvider.state(userPurchaseSection);
// $stateProvider.state(userProfileSection);
//     $stateProvider.state(userBorrowBooksSection);
//   $stateProvider.state(userRentedBooksSection);
//   $stateProvider.state(userWalletSection);
//
//});