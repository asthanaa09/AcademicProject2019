/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.classes;

public class Order {

    public String OrderId = "";
    public String userId = "";
    public String bookIsbn = "";
    public String sellerId = "";
    public int bookQuantity = 0;
    public String dateAndTime = "";
    public double bookAmount = 0.0;
    public double totalAmount = 0.0;
    public String shiippingAddress = "";
    public String orderStatus = "";
    public String paymentStatus = "notdone";
    public String pincode = "";
    public String paymentMode = "";

    public Order(String OrderId, String userId, String bookIsbn, String sellerId, int bookQuantity,
            double bookAmount, double totalAmount, String shiippingAddress, String pincode, String orderStatus,String paymentStatus, String paymentMode) {

        this.OrderId = OrderId;
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.sellerId = sellerId;
        this.bookQuantity = bookQuantity;
    this.bookAmount = bookAmount;
        this.totalAmount = totalAmount;
        this.shiippingAddress = shiippingAddress;
        this.pincode = pincode;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.paymentMode = paymentMode;

    }
public Order(String orderId){

this.OrderId=orderId;


}
}
