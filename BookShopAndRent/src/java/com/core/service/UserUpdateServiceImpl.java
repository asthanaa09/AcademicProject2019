/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.Dao.UpdateDao;
import com.core.Dao.UpdateDaoImpl;
import com.core.classes.AppError;
import com.core.jsonUtil.JsonUtil;

/**
 *
 * @author kapil
 */
public class UserUpdateServiceImpl implements UserUpdateService {
    @Override
    public String update(Object o,String sql){
    
    
    //call updateDaoImpl class
    UpdateDao upDao=new UpdateDaoImpl();
    AppError result=(AppError)upDao.getUpdate(o,sql);
    
    
    
    //convert result into json object
    String jsonObj=JsonUtil.javaToJson(result);
    //return json object}
    return jsonObj;
    
    
    }
}
