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
public class Book {

    private String sellerId = "";
    private String bookTitle = "";
    private String isbn = "";
    private String discription = "";
    private String bookLanguage = "";
    private String authour = "";
    private int pageNo;
    private int copies;
    private double price;
    private String bookImage = "";
    private String bookSample = "";

    public Book(String sellerId, String bookTtitle, String isbn, String discription, String bookLanguage, String authour,
            int pageNo, int copies, double price, String bookImage, String bookSample) {
       
        
               this.sellerId = sellerId;
        this.bookTitle = bookTtitle;
        this.isbn = isbn;
        this.discription = discription;
        this.bookLanguage = bookLanguage;
        this.authour = authour;
        this.pageNo = pageNo;
        this.copies = copies;
        this.price = price;
        this.bookImage = bookImage;
        this.bookSample = bookSample;
    
    
    
    
    }

}
