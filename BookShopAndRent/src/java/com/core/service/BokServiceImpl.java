/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.Dao.BookDao;
import com.core.Dao.BookDaoImpl;
import com.core.classes.Book;
import com.core.jsonUtil.JsonUtil;
import java.util.List;

/**
 *
 * @author kapil
 */
public class BokServiceImpl implements BookService {
    
    
    public String getBookDetails(){
        //call BookDaoImpl class method
        BookDao bookDao=new BookDaoImpl();
        List<Book> list=bookDao.getBookDetails();
        
        
        
        //conver list object into json object
        
        String jsonObj=JsonUtil.javaToJson(list);
//        return th converted java object into json object to servlet
    
    
    return jsonObj;
    }
    
          public String getPerticularBookDetails(String isbn){return null;}
    
}
