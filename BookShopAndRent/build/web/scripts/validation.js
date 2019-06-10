function loginValidation(){
    
    var username=document.getElementById('username').value;
    var password=document.getElementById('password').value; 
   
    ///validation start
    //1. cheching empty
    if(username==""||password==""){
        if(username=="")
        {
            document.getElementById('usernameSpan').innerHTML="**user name could't empty";
            return false;
            
        }
         if(password=="")
        {
            document.getElementById('passwordSpan').innerHTML="**user name could't empty";
            return false;
            
        }
        
        
        
    }
    //2. email and password valiation thats is email no or chracter
    if(!isNaN(username)){
        document.getElementById('usernameSpan').innerHTML="**please enter valid Email";
        return false;
    }
    if(username[0]=="@"){
       
       document.getElementById('usernameSpan').innerHTML="**please enter valid Email";
        return false; 
        
    }
    
   
   
}

///function for Registration Form Validation

function regValidation()
{
    var firstName = document.getElementById('t1').value;
    var midName = document.getElementById('regMnamee').value;
    var lastName = document.getElementById('regLname').value;
    var emailo = document.getElementById('regEmail').value;
    var mobileNo = document.getElementById('regMobileNo').value;
    var password = document.getElementById('regPassword').value;
    var shippingAdd = document.getElementById('regShipAdd').value;
    var gender = document.getElementById('username').value;
  if(firstName=="")
        {
            document.getElementById('sp').innerHTML=firstName;
            return false;
            
        }
return FALSE;
}
