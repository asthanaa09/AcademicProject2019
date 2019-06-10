/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.Dao.MakeOrder;
import com.core.Dao.MakeOrderImpl;
import com.core.classes.AppError;
import com.core.classes.Order;
import com.core.jsonUtil.JsonUtil;

/**
 *
 * @author kapil
 */
public class MakeOrderServiceImpl implements MakeOrderService{    
    
     public boolean makeOrder(Order o){
     
     //calling makeOrder dao
     String jSonObj;
     MakeOrder mo=new MakeOrderImpl();
     boolean orderStatus=mo.makeOrder(o);
     System.out.println(orderStatus);
     
         return orderStatus;
     
     }
    
    
    
    
}
