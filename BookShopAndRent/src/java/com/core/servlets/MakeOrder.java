/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.servlets;

import com.core.classes.AppError;
import com.core.classes.Order;
import com.core.classes.RandomString;
import com.core.jsonUtil.JsonUtil;
import com.core.service.MakeOrderService;
import com.core.service.MakeOrderServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kapil
 */
public class MakeOrder extends HttpServlet {

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

        PrintWriter pw=response.getWriter();
         HttpSession session=request.getSession(false);
        String json;
        String orderId=RandomString.getOrderId();
        String sellerId,userId,address,pincode,isbn;
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        double price=Double.parseDouble(request.getParameter("price"));
        
        sellerId=request.getParameter("sellerId");
        userId=(String)session.getAttribute("userid");
        address=request.getParameter("address");
        pincode=request.getParameter("pincode");
        isbn=request.getParameter("isbn");
        
        //creating order object
         Order o=new Order(orderId, userId,isbn,  sellerId,quantity,price,(price*quantity),address,pincode,"placed","unpaid","notChoosen");
   
       //inserting order information into the database
       MakeOrderService mks=new MakeOrderServiceImpl();
       boolean result=mks.makeOrder(o);
        if(result==true){
        json=JsonUtil.javaToJson(orderId);
        pw.write(json);
        }
        else
        {
        AppError error=new AppError("false");
        json=JsonUtil.javaToJson(error);
        pw.write(json);
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
