<%-- 
    Document   : Test
    Created on : Jan 19, 2019, 3:25:44 PM
    Author     : kapil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">-->
        <link href="//fonts.googleapis.com/css?family=Oswald:200,300,regular,500,600,700&subset=latin-ext,vietnamese,latin,cyrillic" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" href="css/style.css">

        <title>Online Book Shopping & Renting site</title>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="scripts/indexJs.js"></script>
        <script src="scripts/RegistrationValidation.js"></script>
        <script src="scripts/jssor.slider-27.5.0.min.js" type="text/javascript"></script>
        <script src="scripts/validation.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
        <script src="http://code.angularjs.org/1.2.13/angular.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.8/angular-ui-router.min.js"></script>
        <script src="scripts/RegistrationValidation.js">
                   </script>
        <script src="scripts/ModuleRouting.js"></script>
        <!--image slaider work-->
       <style>


            /*jssor slider loading skin spin css*/
            .imgs{

                height:15rem;
            }
            .jssorl-009-spin img {
                animation-name: jssorl-009-spin;
                animation-duration: 1.6s;
                animation-iteration-count: infinite;
                animation-timing-function: linear;
            }

            @keyframes jssorl-009-spin {
                from { transform: rotate(0deg); }
                to { transform: rotate(360deg); }
            }

            /*jssor slider bullet skin 052 css*/
            .jssorb052 .i {position:absolute;cursor:pointer;}
            .jssorb052 .i .b {fill:#000;fill-opacity:0.3;}
            .jssorb052 .i:hover .b {fill-opacity:.7;}
            .jssorb052 .iav .b {fill-opacity: 1;}
            .jssorb052 .i.idn {opacity:.3;}

            /*jssor slider arrow skin 053 css*/
            .jssora053 {display:block;position:absolute;cursor:pointer;}
            .jssora053 .a {fill:none;stroke:#fff;stroke-width:640;stroke-miterlimit:10;}
            .jssora053:hover {opacity:.8;}
            .jssora053.jssora053dn {opacity:.5;}
            .jssora053.jssora053ds {opacity:.3;pointer-events:none;}
       
       /*contact us modal css*/
       /* The Modal (background) */
.modal2 {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */

       </style>

    <!--image silder works ended here-->
</head>
   









<body ng-app="helloworld" >
    
    
       <!--<hjhg%=(String) session.getAttribute("url")%>-->
    <!--<da%=session.getAttribute("logInStatus")%>-->
      <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top offer" id="fn1">
        <div class="container-fluid" >
            <h6  id="offer">30% of on purchase of any book</h6>     

        </div>

    </nav>
    <!--second navbar---><header>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
            <div class="container-fluid" >
                <a class="navbar-brand" href="index.jsp" ><img src="img/books.png">BookMine</a>

                <button class="navbar-toggler navbar-toggler-left" type="button" data-toggle="collapse" data-target="#navbarResponsive">   
                    <span class="navbar-toggler-icon"></span></button>
                <!--srch box-->



                <div class="collapse-navbar-collapse" id="navbarResponsive">

                    <ul class="navbar-nav mr-auto">
                        <li>
                            <button type="button" class="srchBtn" id="srchBtn" onclick="search()"><img src="img/srchIcon.png"  id="srchImg"></button>
                        </li>
                         <li class="nav-item active">
                             <a class="nav-link" href="#"><img src="img/home5.png" alt="Home"> <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item active">
                            <a class="nav-link"  href="admin.html" > <bold>Admin Login</bold></a>
                        </li>
      
                        <!--//using bootstrap 4 login systemeditable-->
                         <% if ((String) session.getAttribute("logInStatus") == "in") {%>
                         <li class="nav-item dropdown">
        <a class="nav-link " href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <p  ng-controller="UserProfile" ><%//="Hello" + " " + (String) session.getAttribute("userName")%><font color="white">{{fName}}</font></p>
                                 
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <div ng-controller="UserProfile" class="dropdown-item" > <a ui-sref="userProfileSection" ui-sref-active="active" class="dropdown-item">Profile</a></div>
           
           <a ui-sref="userPurchaseSection" ui-sref-active="active" class="dropdown-item">Your Purchases</a>
                                        <!--<a ui-sref="userBorrowBooksSection"  ui-sref-active="active" class="dropdown-item">Borrowed order</a>-->
                                        <!--<a ui-sref=" userRentedBooksSection" ui-sref-active="active" class="dropdown-item">Rent Book</a>-->
                                        <!--<a ui-sref="userWalletSection" ui-sref-active="active" class="dropdown-item">My Wallet</a>-->
                                        <form action="./SystemLogOut" method="get"><button class="TitleBtn  dropdown-item">LogOut</button></form>
                                  
          
          
          
            </div>
      </li><%} else {%>

                                <!--<button tye="button" class="btnn " style="background-color: #555555;"   onclick="loginForm()" id="logbtn">LogIn/SignUp</button>-->
                       <li class="nav-item active">
        <a class="nav-link" href=""    onclick="loginForm()" id="logbtn">LogIn/SignUp <span class="sr-only">(current)</span></a><%}%>
      </li>
                                <!--ended here-->
                        
                        
                        
                        
<!--from here login system is build using jsp-->
<!--                        <li class="nav-item active mr-auto">
                            <a class="nav-link"  href="#" onclick style="width:auto;">
                                <//% if ((String) session.getAttribute("logInStatus") == "in") {%>
                                <div class="dropdown nav-item active ">
                                    <p class="dropbtn" ng-controller="UserProfile" ><%//="Hello" + " " + (String) session.getAttribute("userName")%><font color="white">{{fName}}</font></p>
                                    <div class="dropdown-content">
                                        <div ng-controller="UserProfile"  > <a ui-sref="userProfileSection" ui-sref-active="active">Profile</a></div>

                                        <a ui-sref="userPurchaseSection" ui-sref-active="active">Your Purchases</a>
                                        <a ui-sref="userBorrowBooksSection"  ui-sref-active="active">Borrowed order</a>
                                        <a ui-sref=" userRentedBooksSection" ui-sref-active="active">Rent Book</a>
                                        <a ui-sref="userWalletSection" ui-sref-active>My Wallet</a>
                                        <form action="./SystemLogOut" method="get"><button class="TitleBtn">LogOut</button></form>
                                    </div>

                                </div><//%} else {%>

                                <button tye="button" class="btnn " style="background-color: #555555;"   onclick="loginForm()" id="logbtn">LogIn/SignUp</button><//%}%>
                        </li>-->
         <!--jsp login system enden here-->
                        <li class="nav-item active">
                            <a class="nav-link"  href="#"><div class="dropdown nav-item active" ></div>Cart</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link"  href="" id="help"> Help</a>
                        </li>
                        <li class="nav-item active">





                            <!--<a class="nav-link" ui-sref="home"  > Borrow Book</a>-->

                        </li>
                        <li class="nav-item active">
                            <a class="nav-link"  href="footer" > Contact Us</a>
                        </li>
                        

                    </ul>


                </div>  


            </div>

        </nav></header>

    <!--search box work--->
    <nav class="navbar navbar-expand-md navbar-light bg-dark sticky-top offer" id="nav3">
        <form action="Search.jsp" class="form-inline justify-content-center">
            <!--write here-->

            <div class="sample">
                <input type="text" class="inputField" name="search" placeholder="Search..">
                <button type="submit" class="btn btn-outline-primary sm-2">Search</button>
                <button type="button" class="btn btn-outline-danger" id="cancel" onclick="nav3Show()">X</button>
            </div>
        </form>
    </nav>
    
  
   <!--this anchor tag is used to containt the url of carts home page called home.jsp-->
     <a ui-sref="home" ui-sref-active="active"></a>
    <!--<a ui-sref="about" ui-sref-active="active">About</a>-->
 

   <div ui-view>anurag asthana</div>
    
   
   <!--for log in system controller is ng-controller="login"-->
     <div id="id01" class="modal" >
        <div class="modal-dialog modal-dialog-centered animate" >
            <div class="modal-content">
                <div class="modal-header bg-light">
                    <h3>LogIn</h3>
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="closee" title="Close Modal">
                        &times;<!--this is special attribute of html which shows cross elemt on the page study about those attribute--->
                    </span>
                </div>
                <div class="modal-body ">
                    <div class="form  ">
                        <form  action="./logInValidation" method="post" onsubmit="return loginValidation()" class="form-group" >
                            <span class="badge badge-primary">Username</span></br>
                            <input type="text" name="uname" id="username"  class="form-control" placeholder="enter email" required>
                            <span id="usernameSpan" class="badge badge-light bg-danger"></span></br>
                            <span class="badge badge-primary">Password</span></br>
                            <input type="password" class="form-control" name="pw" id="password" placeholder="enter password" required></br>
                            <span id="passwordSpan"></span></br>
                            <button type="submit" class="btn btn-outline-primary btn-group-lg ml-auto"  ng-click="logon()" >LogIn</button>  
                            <label>Recover</label> <a href=''> Password</a> or <a href=''> userId</a>
         
         <input type="hidden"  id="hiddentinputatIndex" value="" name="hiddentinputatIndex">

                        </form>
                    </div>
                    <div class="modal-footer bg-dark">
                        <label class="text-info">Don't have an account</label> 
                        <button id="reg"  class="text-danger TitleBtn"  ><b><a ui-sref="anurag" >SignUp</a></b></button>


                    </div>

                </div>


            </div>




        </div>

    </div></br>
    
                         
    
    <!--/footer-->
     <footer class="bg-dark " id="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                      <font color="white"><h3>About Us</h3></font>
                  <font color="white">  <p> My self Anurag Asthana (B.Tech from the Department Of Computer Science & Engineering) student of Ansal Technical Campus </br>
                    <p>  affiliated from Dr. A.P.J. Abdul Kalam Technical University Uttar Pradesh, Lucknow</p>
</font>
                </div>
                <div class="col-md-2 list">
                    <ul>
                        <li><a href="index.jsp">Index Page</a></li>
                        <li><a href="#">Page</a></li>
                        <li><a href="#">Page</a></li>
                        <li><a href="#">Page</a></li>
                    </ul>

                </div>
                <div class="col-md-2 list">
                    <ul>
                        <li><a href="#">Page</a></li>
                        <li><a href="#">Page</a></li>
                        <li><a href="#">Page</a></li>
                        <li><a href="#">Page</a></li>
                    </ul>

                </div>
                <div class="col-md-2">

                </div>
                <div class="col-md">
                    <font color="white">  <h5><strong >Contact Info</strong></h5>
                    <p><strong>Adress:</strong> xyz
                        lucknow<!-- Random Adress -->
                    </p>
                    <p><strong>Email:</strong> astxxxxxgmail.com</p>
                    <p><strong>contact no :</strong> (+91) xxxxxxx582235</p></font>
                </div>
            </div>
        </div></br></br>
        <!--  <div class="container">
            <div class="row">
              <div class="col-md text-center">
        
              © 2010-<?php# echo date("Y");?>
        
            </div> -->

        <div>  <ul class="ic ">
                <li><a href="https://www.facebook.com/anurag.asthana.315"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
                <li><a href="https://www.linkedin.com/in/raj-kumar-web-designer/"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
            </ul></div>


    </footer>
    
    <!--on scroll top button-->
    
<button onclick="topFunction()" id="myBtn" title="Go to top"><img src="img/top_arrow.png"></button>
<script>
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    document.getElementById("myBtn").style.display = "inline-block";
  } else {
    document.getElementById("myBtn").style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>
<!--//contact us modal-->
<!-- The Modal -->

<!-- Trigger/Open The Modal -->


<!-- The Modal -->
<div id="myModal5" class="modal5 ">

  <!-- Modal content -->
  <div class="modal5-content bg-light">
   
    <div class="modal5-header" ">
     <span class="close">&times;</span>
    <h2 style="font-family: serif">How May I Help You</h2>
  </div></br>
      
  <center>
     <iframe width="500" height="315" src="https://www.youtube.com/embed/B202UQwpTOM" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="500" height="315" src="https://www.youtube.com/embed/ZG0JJeaKJaE" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
     
      </center>
 

  </div>

</div>
<style>
/* Modal Header */
.modal5-header {
  padding: 2px 16px;
  background-color: #142030;
  color: white;
}

/* The Modal (background) */
.modal5 {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4);  /*Black w/ opacity */
}

/* Modal Content */
.modal5-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  border: 1px solid #888;
  width: 80%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
  -webkit-animation-name: animatetop;
  -webkit-animation-duration: 0.4s;
  animation-name: animatetop;
  animation-duration: 0.4s
  
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
/* Add Animation */
@-webkit-keyframes animatetop {
  from {top:-300px; opacity:0} 
  to {top:0; opacity:1}
}

@keyframes animatetop {
  from {top:-300px; opacity:0}
  to {top:0; opacity:1}
}

</style>
<script>
// Get the modal
var modal = document.getElementById('myModal5');

// Get the button that opens the modal
var btn = document.getElementById("help");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>


</body>
</html>
