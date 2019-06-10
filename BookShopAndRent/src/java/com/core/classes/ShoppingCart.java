/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.classes;

/**
 *
 * @author kapil
 */
public class ShoppingCart {
    
    public String isbn="";
    public String  seller_id="";
    public int quantity;
    public ShoppingCart(String isbn,String seller_id,int quantity){
    
    this.isbn=isbn;
    this.seller_id=seller_id;
    this.quantity=quantity;
    
    }
    
    
    
}
