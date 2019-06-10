$(document).ready(function(){
    $('.icon').click(function(){
        $('.search').toggleClass('active');
    });
});

function search(){
$(document).ready(function(){
    $("#srchImg").click(function(){
        $("#nav3").slideDown(500);
         $("#srchImg").hide(500);
            });
});


}
function nav3Show()
{
   $(document).ready(function(){
    $("#cancel").click(function(){
        $("#nav3").hide(500);
         $("#srchImg").show(500);
            });
});
   
}
function registerForm()
{
  var x = document.getElementById("id01");
  
    if (x.style.display === "block") 
    {
         x.style.display = "none";
        /* //document.getElementById("regForm").style.display="grid";
         $(document).ready(function(){
    $("#reg").click(function(){
        $("#regForm").show(1200);
    });
});*/
        
            
        
    }
    
   //here write the code to show the registration form
    
}
function loginForm(){
    
    
     var url=window.location.href;
         document.getElementById('hiddentinputatIndex').setAttribute('value', url);
//          document.getElementById('hiddentinputatIndex').innerHTML=url;
    document.getElementById("id01").style.display="block";
    
       
           
            //document.getElementById("regForm").style.display="none";
          $(document).ready(function(){
    $("#logbtn").click(function(){
        $("#regForm").hide(1200);
    });
});
           
       
        
        
        
    
    
}
//function for working hamburger button

function openButton(x) {
  x.classList.toggle("change");
}
