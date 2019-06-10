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
import javax.servlet.http.HttpSession;

/**
 *
 * @author kapil
 */
public class logInValidation extends HttpServlet {

    
    
      String user_Id;
      String password;
      String logInStatus=null;
      
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrintWriter pw=response.getWriter();
        String userId=request.getParameter("uname");
        String password=request.getParameter("pw");
     
        
     
        //validation start
       boolean emailValStatus=logInValidation.validateEmail(userId,pw);
     
       //alter varification of password we redirectng to logIn servlet-----------
       if(emailValStatus==true){
    
    RequestDispatcher reqd=request.getRequestDispatcher("/SystemLogIn");//url pattern
     reqd.forward(request,response);
     
     
     }
       else{
       
       Error er=new Error("some internal error");
       pw.print(er);
       }
        
    }
//this function cares about before and afetr @ any character
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
     
     
     
    
     
     
}