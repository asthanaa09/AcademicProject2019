


function regValidation() {
    
    
    let firstName = document.getElementById("regFname").value;
    let midName = document.getElementById('regMname').value;//no validation needed
//    let lastName = document.getElementById('regLname').value;//no validation needed
    let email = document.getElementById('regEmail').value;
    let mobileNo = document.getElementById('regMobileNo').value;
  let password = document.getElementById('regPassword').value;
   let shippingAdd = document.getElementById('regShipAdd').value;
   let gender = document.querySelector('input[name="regGender"]:checked').value
   let pincode=document.getElementById('regPincode').value;
//
//
    if (firstName == "" || firstName.length < 2) {
        alert("first Name empty or minimum 2 words are required");
        return false;
    }
     if (pincode == "" || (pincode.length < 6)) {
        alert("Pincode must be in 6 digit numeric number");
        return false;
    }
     if(isNaN(pincode)){alert("only numeric pincode accepted");return false;}


   let emailStatus = emailVal(email);
//
//
    if (emailStatus == false) {
        alert("please Enter the Valid Email");
        return false;
    } else
    {
      //moble validation
        if (mobileNo == "") {
            alert("please enter mobile no");return false;
        }
        if(isNaN(mobileNo)){alert("please enter only numeric mobile number");return false;}
        if(mobileNo.length<10){
            alert("mobie no must be 10 digits"); return false;
        }
//   
//        
//        
//        
//        
//        
//        
   }












}


function emailVal(email) {
    let reEmail = /^(?:[\w\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+\.)*[\w\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+@(?:(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9\-](?!\.)){0,61}[a-zA-Z0-9]?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9\-](?!$)){0,61}[a-zA-Z0-9]?)|(?:\[(?:(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])\]))$/;

    if (!email.match(reEmail)) {
        // alert("Invalid email address");
        return false;
    }

    return true;

}
