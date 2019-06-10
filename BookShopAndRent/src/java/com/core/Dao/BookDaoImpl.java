/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Dao;

import com.core.classes.Book;
import com.core.servlets.connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kapil
 */
public class BookDaoImpl implements BookDao{
    
      @Override
    public List<Book> getBookDetails(){
        
        List<Book> list=new ArrayList();
        Connection con=null;
        ResultSet rs=null;
        Statement st=null;
        
          try {
                con = new connection().dbConnection();
              st=con.createStatement();
              rs=st.executeQuery("select * from book_stock");
              while(rs.next()){
             
                  Book book=new Book(rs.getString("Seller_id"),rs.getString("book_title"),rs.getString("isbn"),rs.getString("discription"),rs.getString("book_language"),rs.getString("authour"),rs.getInt("pages"),rs.getInt("copies"),rs.getDouble("price"),rs.getString("book_image"),rs.getString("book_sample"));
                 list.add(book);
                   
              }
              
          } catch (SQLException e) {
              e.printStackTrace();
          }finally{
          
              try {
                  rs.close();
                  st.close();
                  con.close();
              } catch (Exception e) {
              }
          
          
          }
    
    
    //returning the list object
    return list;
    }
    
    public Book getBook(String isbn){return null;}
    
}
