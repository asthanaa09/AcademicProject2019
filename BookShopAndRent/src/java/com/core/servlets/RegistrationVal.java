/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kapil
 */
public class RegistrationVal extends HttpServlet {

  private String firstName="";
  private String midName="";
  private String lastName="";
  private String email="";
  private String mobile="";
  private String password="";
  private String shippingAdd="";
  private String gender="";
  private String pincode="";
 
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      PrintWriter pw=response.getWriter();
      firstName=request.getParameter("regFirstName");
   midName=request.getParameter("regMidName");
   lastName=request.getParameter("regLastName");
  email=request.getParameter("regEmail");
   mobile=request.getParameter("regMobNo");
   password=request.getParameter("regPassword");
  shippingAdd=request.getParameter("regShipAdd");
   gender=request.getParameter("regGender");
 pincode =request.getParameter("regPincode");
 
           //checking empty values in the field
        if (firstName.equals("")) {
            pw.print("<h1>First name should not be empty</h1>");
        }
        if (midName.equals("")) {
            midName=null;
        }
        if (lastName.equals("")) {
            lastName=null;
        }
       
        if (email.equals("")) {
            pw.print("<h1>Email name should not be empty</h1>");
        }
        if (mobile.equals("")) {
            pw.print("<h1>mobile no"
                    + " should not be empty</h1>");
        }
        if (shippingAdd.equals("")) {
            pw.print("<h1>shippingAdd should not be empty</h1>");
        }
        if (password.equals("")) {
            pw.print("<h1>passwordshould not be empty</h1>");
        }
        if (pincode.equals("")) {
            pw.print("<h1>pincode should not be empty</h1>");
        }
        //email validation & mobile number
      boolean emailValStatus=RegistrationVal.validateEmail(email,pw);
      boolean mobileValStatus=RegistrationVal.isMobileValid(mobile);
          

        if((emailValStatus)&&(mobileValStatus)){
      
       pw.print(shippingAdd+gender+pincode);
         RequestDispatcher reqd=request.getRequestDispatcher("/UserRegistration");//url pattern
        reqd.forward(request,response);
     
      }
        else{
        if(mobileValStatus==false){ pw.print("<h1>moble no should not be empty</h1>");
            pw.println("<script>https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js</script>");
            pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
            pw.println("  <script>");
            pw.println(" $document.ready(function(){");
            pw.println(" swal ( \"Oops\" ,  \"Something went wrong!\" ,  \"error\" )");
//            pw.println("  'Good job!',\n");
//            pw.println("  'You clicked the button!',\n");
//            pw.println("  'success'\n");
            pw.println(")");
            pw.println("  });");
            pw.println("  });");
            pw.println("</script>");
            
        
        }
        
        }
      //here is the code for distpatching request to  store form values in the database after compl;eting the validation
     
  
      
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //email varification process
     public static boolean isValid(String email) 
    { 
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()==true) {

            return true;//email is valid
        } else {
            return false;
        }
   
}    /*/this function is used to validate before @ part of email that is 
     
     1) A-Z characters allowed
2) a-z characters allowed
3) 0-9 numbers allowed
4) Additionally email may contain only dot(.), dash(-) and underscore(_)
5) Rest all characters are not allowed*/
     
     public static boolean namePartEmail(String email){
     
         String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

         Pattern pattern = Pattern.compile(regex);

         Matcher matcher = pattern.matcher(email);
         if (matcher.matches() == true) {

             return true;//email is valid
         } else {
             return false;
         }}
     
     //Java email validation permitted by RFC 5322 Regex : ^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$
    public static boolean thirdEmailValidation(String email) {

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == true) {
            return true;

        } else {
            return false;
        }

    }
    //Regex to restrict leading, trailing, or consecutive dots in emails
    public static boolean fourthEmailValidation(String email){
    
    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == true) {
            return true;

        } else {
            return false;
        }

    }
    //Regex to restrict no. of characters in top level domain [Recommended]
    public static boolean fifthEmailValidation(String email){
    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == true) {
            return true;

        } else {
            return false;
        }
    
    
    }
    
    
     
     
     
     //actual method which calling submethod for email validation
     public static boolean validateEmail(String email,PrintWriter pw)
     {
         boolean isvalSta = isValid(email);
         boolean status = logInValidation.namePartEmail(email);
         boolean status2=logInValidation.thirdEmailValidation(email);
         boolean status3=logInValidation.fourthEmailValidation(email);
         boolean status4=logInValidation.fifthEmailValidation(email);
         if( (isvalSta==true)&&(status == true)&&(status2==true)&&(status3==true)) {

             return true;

         } else {
             pw.println("email is not valid");
             return false;
         }

         
     }
     public static boolean isMobileValid(String s) 
    { 
        // The given argument to compile() method  
        // is regular expression. With the help of  
        // regular expression we can validate mobile 
        // number.  
        // 1) Begins with 0 or 91 
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 9 digits 
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
  
        // Pattern class contains matcher() method 
        // to find matching between given number  
        // and regular expression 
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    } 
    
    
    
    
    
}
