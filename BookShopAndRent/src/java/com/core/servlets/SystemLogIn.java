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
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.ir.Statement;

/**
 *
 * @author kapil
 */
public class SystemLogIn extends HttpServlet {

    String logInStatus = null;
    Connection con = null;
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;
    HttpSession session =null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String userId = request.getParameter("uname");
        String password = request.getParameter("pw");
        String url=request.getParameter("hiddentinputatIndex");
        try {
            con = new connection().dbConnection();

            if (con != null) {
                pst = con.prepareStatement("select * from login_dtls where user_id=? and password=?");
                pst.setString(1, userId);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    logInStatus = "in";
                    session = request.getSession();
                    session.setAttribute("logInStatus", logInStatus);
                    session.setAttribute("userName", rs.getString("first_name"));
                    session.setAttribute("userid",rs.getString("user_id"));
//                    session.setAttribute("url",url);
//                    pw.println(logInStatus+url);

                    response.sendRedirect(url);
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

            } catch (SQLException e) {
            }

        }

    }

}
