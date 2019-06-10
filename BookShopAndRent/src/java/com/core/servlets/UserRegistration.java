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
import jdk.nashorn.internal.ir.Statement;

/**
 *
 * @author kapil
 */
public class UserRegistration extends HttpServlet {

    private String firstName;
    private String midName;
    private String lastName;
    private String email;
    private String mobile;
    private String password;
    private String shippingAdd;
    private String gender;
    private String pincode;

    //database objects
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

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
        
        PrintWriter pw = response.getWriter();
        firstName = request.getParameter("regFirstName");
        midName = request.getParameter("regMidName");
        lastName = request.getParameter("regLastName");
        email = request.getParameter("regEmail");
        mobile = request.getParameter("regMobNo");
        password = request.getParameter("regPassword");
        shippingAdd = request.getParameter("regShipAdd");
        gender = request.getParameter("regGender");
        pincode = request.getParameter("regPincode");
        try {
            con = new connection().dbConnection();

            if (con != null) {
                pst = con.prepareStatement("insert into login_dtls values(?,?,?,?,?,?,?)");
                pst.setString(1,email);
                pst.setString(2,password);
                pst.setString(3,firstName);
                pst.setString(4,midName);
                pst.setString(5,lastName);
                pst.setString(6, mobile);
                pst.setString(7,gender);
                
                boolean a=pst.execute();
                if(!a) {
                        pst.close();
                        pst=con.prepareStatement("insert into user_shipping_address values(?,?,?)");
                        pst.setString(1, email);
                        pst.setString(2,shippingAdd);
                        pst.setString(3, pincode);
                         boolean status=pst.execute();
                        if(!status){
                             
                          response.sendRedirect("index.jsp");
                        
                        }else{
                        pw.print("invalid address or pincode data");
                        }
                        
                        
                  
                } else {

                    pw.print("invalid entered data");//

                }
//successfull log n complete
            }

        } catch (SQLException excep) {
            pw.println(excep.getMessage());
        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException e) {pw.print(e+"\n"+"registration servlet");
            }

        }

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
