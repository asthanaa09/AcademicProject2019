/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.servlets;

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

/**
 *
 * @author kapil
 */
public class MakePayment extends HttpServlet {

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
//          response.setContentType("application/json");
        //method level variable
        PrintWriter pw=response.getWriter();
          Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String orderId=request.getParameter("orderId");
        double paidAmount=0.0;
        String transactionStatus="success";
        int a=0;
        


//receive OrderId from the angular controller

       //fetching oder details throug orderId
         try {
        con=new connection().dbConnection();
     
        if (con != null&&orderId!=null) {
                pst = con.prepareStatement("select total_amt from book_order where order_id=? ");
                pst.setString(1, orderId);//order id entered
               rs = pst.executeQuery();
                if (rs.next()) {
                   paidAmount=rs.getDouble("total_amt");


                  
                } else {

                }

                }
    } catch (SQLException e) {
        e.printStackTrace();
       try{con.close();
        pst.close();
        rs.close();}
       catch (SQLException ep) {
           ep.printStackTrace();
       }
        
    }
    finally{
    
    try{con.close();
        pst.close();
        rs.close();}
       catch (SQLException ep) {
           ep.printStackTrace();
       }
    
    }
       

  
   
   
   
       
       //creating transaction
       
        try {
        con=new connection().dbConnection();
     
        if (con != null) {
                pst = con.prepareStatement("insert into payment values(transaction_id.nextval,?,?,(select sysdate from dual),?) ");
                pst.setString(1, orderId);//order id entered
                pst.setString(2,transactionStatus);
                pst.setDouble(3,paidAmount);
                a = pst.executeUpdate();
                if (a!=0) {
                   System.out.println("transaction done");


                  
                } else {

                }

                }
    } catch (SQLException e) {
        e.printStackTrace();
       try{con.close();
        pst.close();
        rs.close();}
       catch (SQLException ep) {
          ep.printStackTrace();
       }
        
    }
    finally{
    
    try{con.close();
        pst.close();
        rs.close();}
       catch (SQLException ep) {
           ep.printStackTrace();
       }
    
    }
       
       
   
       
   
    }
    // decrease quantity of a book after succesfull payment

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
