/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

/**
 *
 * @author kapil
 */
public interface BookService {
    
    public String getBookDetails();
    // above method is return the json object
      public String getPerticularBookDetails(String isbn);
    
}
