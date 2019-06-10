/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Dao;

import com.core.classes.Order;
import com.core.servlets.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kapil
 */
public class MakeOrderImpl implements MakeOrder{
    
    public boolean makeOrder(Order o)
    {
        boolean orderStatus=false;
        Connection con=null;
        int updatedRow=0;
        PreparedStatement pst=null;
        //writing persistance logic here
        try {
            con = new connection().dbConnection();
            //insert into book_order values('a','asthanaa09@gmail.com','qw2w21','asthanaa09@gmail.com',12,(select sysdate from dual),12.5,123.5,'aswq','226017','placed','unpaid','cod') 
             String sql=" insert into book_order values(?,?,?,?,?,(select sysdate from dual),?,?,?,?,?,?,?)";
          pst=con.prepareStatement(sql);
          pst.setString(1,o.OrderId);
          pst.setString(2,o.userId);
          pst.setString(3,o.bookIsbn);
          pst.setString(4,o.sellerId);
           pst.setInt(5, o.bookQuantity);
         pst.setDouble(6,o.bookAmount);
         pst.setDouble(7,o.totalAmount);
         pst.setString(8,o.shiippingAddress);
         pst.setString(9,o.pincode);
         pst.setString(10,o.orderStatus);
         pst.setString(11,o.paymentStatus);
         pst.setString(12,o.paymentMode);
         
         updatedRow=pst.executeUpdate();
         if(updatedRow!=0){
         orderStatus=true;
         
         
         }
         else
         {
         orderStatus=false;
         
         }
       
          
          
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
            
    
    
    return orderStatus;
    
    }
    
    
}
