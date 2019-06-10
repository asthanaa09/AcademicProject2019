/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleResultSet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author kapil
 */
public class sellerBookUpload extends HttpServlet {

    
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    static private String filePath;
    private String bookImageName;
    private String bookSample;

    //form attribute
    private String seller_id;
    private String book_title;
    private String isbn;
    private String book_language;
    private String author;
    private String pageNo;
    private String copies;
    private String price;
    private String discription;
    private String convertedFileName;

    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload-location");
    }

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
        PrintWriter out = response.getWriter();
        formFieldAnalyzer(request, response);
        out.print(seller_id + "\n" + book_title + "\n" + isbn + "\n" + book_language + "\n" + author + "\n" + pageNo + "\n" + copies + "\n" + price + "\n" + discription);
        out.println(bookImageName + "   " + bookSample);
        out.println("database code writing");
        {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
                con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle1", "anurag", "asthana");
                 pst=con.prepareStatement("insert into book_stock values(?,(select sysdate from dual),?,?,?,?,?,?,?,?,?,?   )");
                 
               pst.setString(1,seller_id);
                pst.setString(2,book_title);
                pst.setString(3,isbn);
                pst.setString(4,discription);
                pst.setString(5,book_language);
                pst.setString(6,author);
                pst.setInt(7,Integer.parseInt(pageNo));
                pst.setInt(8,Integer.parseInt(copies));
                pst.setDouble(9,Double.parseDouble(price));
                pst.setString(10,bookImageName);
                pst.setString(11,bookSample);
            rs=pst.executeQuery();
            response.sendRedirect("seller_book_upload.html");
            //reading data from bfile column
           

          
            
            
            } catch (ClassNotFoundException | SQLException e) {
                out.println(e+"\n"+e.getMessage()+"\n");
                e.printStackTrace();
                out.print(seller_id);
            }finally{
            try{
            
                
                con.close();
            pst.close();
            rs.close();
            }catch(Exception e){
                
            }
            
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

    private void formFieldAnalyzer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                PrintWriter out = response.getWriter();
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();
                        if (fieldName.equals("seller_id")) {
                            seller_id = fieldValue;
                        }
                        if (fieldName.equals("book_title")) {
                            book_title = fieldValue;
                        }
                        if (fieldName.equals("isbn")) {
                            isbn = fieldValue;
                        }
                        if (fieldName.equals("language")) {
                            book_language = fieldValue;
                        }
                        if (fieldName.equals("pageno")) {
                            pageNo = fieldValue;
                        }
                        if (fieldName.equals("copies")) {
                            copies = fieldValue;
                        }
                        if (fieldName.equals("price")) {
                            price = fieldValue;
                        }
                        if (fieldName.equals("discription")) {
                            discription = fieldValue;
                        }
                        if (fieldName.equals("author")) {
                            author = fieldValue;
                        }

                    } else {
                        // Process form file field (input type="file").
                        String fieldName = item.getFieldName();
                        String fileName = FilenameUtils.getName(item.getName());
                        InputStream fileContent = item.getInputStream();
                        String name = new File(item.getName()).getName();
                        String convertedName = (seller_id+isbn + fileName);
                        item.write(new File(filePath + File.separator + convertedName));

                        out.println(convertedName);
                        // ... (do your job here)
                        convertedFileName = convertedName;
                        if (fileName.contains(".")) {
                            int dotIndex = fileName.indexOf(".");
                            String extension = fileName.substring(dotIndex);
                            out.print(extension);
                            try {
                                if (extension.equals(".png") || extension.equals(".jpg") || extension.equals(".tif") || extension.equals(".tiff") || extension.equals(".bmp") || extension.equals(".jpeg") || extension.equals(".gif") || extension.equals(".eps")) {
                                    out.println(seller_id+"at the -------------");
                                    bookImageName = (seller_id + isbn + fileName);

                                } else {

                                    bookSample = (seller_id + isbn + fileName);
                                }
                            } catch (Exception e) {
                                if (bookImageName.equals(null)) {
                                    out.println("not Vlid Format of BookImage");
                                }
                                if (bookSample.equals(null)) {
                                    out.println("not Vlid Format of book sample file");
                                }
                            }

                        }
                    }
                }
            } catch (Exception e) {
                throw new ServletException("Cannot parse multipart request.", e);
            }

        }

    }

}
