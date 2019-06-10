/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdk.nashorn.internal.ir.Statement;

/**
 *
 * @author kapil
 */
public class connection {
    Connection con=null;
    PreparedStatement pst=null;
    Statement st=null;

public Connection dbConnection(){

try{
Class.forName("oracle.jdbc.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle1","anurag","asthana");
return con;
}
catch(SQLException|ClassNotFoundException excep){
    
    excep.printStackTrace();
    System.out.println("yes exception anurag");
       return null;
    
}






} 




}
