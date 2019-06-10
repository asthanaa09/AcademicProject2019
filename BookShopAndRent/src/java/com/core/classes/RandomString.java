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
public class RandomString {
    // function to generate a random string of length n 
	static String getAlphaNumericString(int n) 
	{ 

		// chose a Character random from this String 
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
									+ "0123456789"
									+ "abcdefghijklmnopqrstuvxyz"; 

		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(n); 

		for (int i = 0; i < n; i++) { 

			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index 
				= (int)(AlphaNumericString.length() 
						* Math.random()); 

			// add Character one by one in end of sb 
			sb.append(AlphaNumericString 
						.charAt(index)); 
		} 

		return sb.toString(); 
	} 

	public static void main(String[] args) 
	{ 

		// Get the size n 
		int n = 15; 

		// Get and display the alphanumeric string 
		System.out.println(RandomString.getAlphaNumericString(n).toUpperCase()+"\n"+getOrderId().length()); 
                
	} 
    
        
        public static String getOrderId(){
        
        int n=9;
          
        return "ORD"+RandomString.getAlphaNumericString(n).toUpperCase()+generateRandom.getRandomNumber();
        }
        
        
        
}
