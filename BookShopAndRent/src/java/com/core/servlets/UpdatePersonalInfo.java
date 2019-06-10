/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.servlets;

import com.core.classes.User;
import com.core.service.UserUpdateService;
import com.core.service.UserUpdateServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kapil
 */
public class UpdatePersonalInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

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
         response.setContentType("application/json");
        PrintWriter pw=response.getWriter();
        String firstName=request.getParameter("firstName");
        String midName=request.getParameter("midName");
        String lastName=request.getParameter("lastName");
        String userId=request.getParameter("userId");
        String gender=request.getParameter("gender");
        String mobileNo=request.getParameter("mobileNo");
        //creating user object
        
        User user=new User( userId, firstName, midName, lastName, gender,mobileNo);
        
         UserUpdateService obj=new UserUpdateServiceImpl();
//    User user=new User("kapilasthana2008@gmail.com","anurag",mobileNo,"asthana","male","8318286471");
    String result=obj.update(user,"update login_dtls set user_id=?,first_name=?,mid_name=?,last_name=?,gender=?,mobileno=? where user_id=?");
  
  pw.write(result);
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

}
