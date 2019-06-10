/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.jsonUtil;

import com.google.gson.Gson;

/**
 *
 * @author kapil
 */
public class JsonUtil {
    
    
    public static Gson gson;
    static {
    
    gson=new Gson();
    
    
    }
    
    public static String javaToJson(Object obj){
    
    String jsonObj="";
    jsonObj=gson.toJson(obj);
    
//returning the json object
return jsonObj;


    }
    
    
    
}
