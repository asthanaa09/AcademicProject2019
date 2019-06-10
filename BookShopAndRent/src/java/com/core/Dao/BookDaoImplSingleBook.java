/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Dao;

import com.core.classes.Book;
import com.core.servlets.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kapil
 */
public class BookDaoImplSingleBook implements BookDao {

    public List<Book> getBookDetails() {
        return null;
    }

    public Book getBook(String isbn) {
        Book book = null;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            con = new connection().dbConnection();
            st = con.prepareStatement("select * from  book_stock where isbn=?");
            st.setString(1, isbn);// eting the isbn partemeter fo finding book
            rs = st.executeQuery();
            while (rs.next()) {

                book = new Book(rs.getString("Seller_id"), rs.getString("book_title"), rs.getString("isbn"), rs.getString("discription"), rs.getString("book_language"), rs.getString("authour"), rs.getInt("pages"), rs.getInt("copies"), rs.getDouble("price"), rs.getString("book_image"), rs.getString("book_sample"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {

            try {
                rs.close();
                st.close();
                con.close();
            } catch (Exception e) {
            }

        }

        return book;
    }

}
