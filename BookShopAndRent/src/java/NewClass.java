
import com.core.servlets.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewClass{
public static void main(String[] ewjh){
    
//   Connection con = null;
//    PreparedStatement pst = null;
//    
//    ResultSet rs = null;
//    try {
//        con=new connection().dbConnection();
//        String orderId="ORDUNUITPNMW564";
//        if (con != null) {
//                pst = con.prepareStatement("select total_amt from book_order where order_id=? ");
//                pst.setString(1, orderId);//order id entered
//               rs = pst.executeQuery();
//                if (rs.next()) {
//                   System.out.println(rs.getDouble("total_amt"));
//
//
//                  
//                } else {
//
//                }
//
//                }
//    } catch (SQLException e) {
//       try{con.close();
//        pst.close();
//        rs.close();}
//       catch (SQLException ep) {
//       }
//        
//    }
//    finally{
//    
//    try{con.close();
//        pst.close();
//        rs.close();}
//       catch (SQLException ep) {
//       }
//    
//    }
//       
//
//  
//   
     Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String orderId="ORDKJ7HB5N7E469";
        double paidAmount=0.0;
        String transactionStatus="success";
        int a=0;


//receive OrderId from the angular controller
//orderId=request.getParameter("orderid");
       //fetching oder details throug orderId
        try {
        con=new connection().dbConnection();
     
        if (con != null) {
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




}