/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Dao;

import com.core.classes.AppError;
import com.core.classes.User;
import com.core.servlets.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kapil
 */
public class UpdateDaoImpl implements UpdateDao {
    
    
    public Object getUpdate(Object o,String sql){
    
        //this class is update the clients personal information
       
         AppError result=null;
        User user=(User)o;
        Connection con=null;
        PreparedStatement pst=null;
        int updatedRow=0;
        try {
            con = new connection().dbConnection();
               pst=con.prepareStatement(sql);
               pst.setString(1,user.UserId);
               pst.setString(2,user.firstName);
               pst.setString(3,user.midName);
               pst.setString(4,user.lastName);
               pst.setString(5,user.mobileNo);
               pst.setString(6,user.gender);
               pst.setString(7,user.UserId);
               int updateRow=pst.executeUpdate();
               if(updateRow!=0){
               result=new AppError("success");
               
               
               }else{
               
              result=new AppError("updation fail");
               }
             
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        
        
        
    //returning result
    
   return  result;
    }
    
    
}
