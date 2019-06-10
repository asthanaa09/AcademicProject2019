/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.classes;

import java.io.Serializable;

/**
 *
 * @author kapil
 */
public class User {
    
    
     public String UserId="";
     public String password="";
     public  String firstName="";
     public  String midName="";
     public String lastName="";
    public String mobileNo="";
    public  String gender="";
  
    
    public  User(String userId,String password,String firstName,String midName,String lastName,String mobileNo,String gender){
    
    this.UserId=userId;
    this.password=password;
    this.firstName=firstName;
    this.midName=midName;
    this.lastName=lastName;
    this.mobileNo=mobileNo;
       this.gender=gender;
    
    
    
    
    }
    
      public  User(String userId,String firstName,String midName,String lastName,String mobileNo,String gender){
    
    this.UserId=userId;
   
    this.firstName=firstName;
    this.midName=midName;
    this.lastName=lastName;
    this.mobileNo=mobileNo;
       this.gender=gender;
    
    
    
    
    }
    
   
    
    
    
    
}
