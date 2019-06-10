/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.servlets;

import com.core.classes.User;


import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kapil
 */
public class GetUserPersonalInfo extends HttpServlet {

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
   
  
    public void inIt() throws ServletException, IOException{
  
   
        
        
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("application/json");
      PrintWriter pw=response.getWriter();
        HttpSession session=request.getSession(false);
        String user_id=(String)session.getAttribute("userid");
          Connection con =null;
           PreparedStatement pst=null;
           ResultSet rs=null;
        User user=null;
        if(session==null){
            pw.write("<center><h5>Your are not Loged In click for <a href='index.jsp'>LogIn</a></h5></center>");}
        else
        {    
        
               
    try {
         con = new connection().dbConnection();
       pst =null;
          rs=null;
         
         
         if (con != null) {
                pst = con.prepareStatement("select * from login_dtls where user_id=?");
                pst.setString(1, user_id);
                rs = pst.executeQuery();
         if(rs.next()){
         
             user=new User(rs.getString("user_id"),rs.getString("password"),rs.getString("first_name"),rs.getString("mid_name"),rs.getString("last_name"),rs.getString("mobileno"),rs.getString("gender"));
          
             }
         
         
         
         }
         
         
              
        
        
         } catch (SQLException e) {
             e.printStackTrace();
         }
    finally{
    try{con.close();
    rs.close();
    pst.close();}catch(SQLException e){e.printStackTrace();}
    
    
    }
           
//           String userJsonObject= userInfo.getUserDetail(user_id);
//          
//           pw.write(userJsonObject);
//            User a=new User("anurag","","","","","","");
            Gson gson=new Gson();
            String obj=gson.toJson(user);
            
            pw.write(obj);
           
        }
        
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
