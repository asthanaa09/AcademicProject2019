/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.Dao.ShippingAddressDao;
import com.core.Dao.ShippingAddressDaoImpl;
import com.core.classes.UserShippingAdd;
import com.core.jsonUtil.JsonUtil;
import java.util.List;

/**
 *
 * @author kapil
 */
public class GetAddServiceImpl implements GetAddService {
    
    
    
        public String getAddress(String userId){
          //call ShippingAddressDao class method
        ShippingAddressDao daoObj=new ShippingAddressDaoImpl();
          List< UserShippingAdd> list=daoObj.getAddress(userId);
          
          
         //conver list object into json object
          String jsonObj=JsonUtil.javaToJson(list);
        
          //return th converted java object into json object to servlet
        return jsonObj;
        }
    
    
    
    
    
}
