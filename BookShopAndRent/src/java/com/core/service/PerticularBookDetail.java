/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.Dao.BookDaoImplSingleBook;
import com.core.classes.Book;
import com.core.jsonUtil.JsonUtil;

/**
 *
 * @author kapil
 */
public class PerticularBookDetail implements BookService {

    public String getPerticularBookDetails(String isbn) {

        //call BookDaoImplSinglBook class method
        BookDaoImplSingleBook obj = new BookDaoImplSingleBook();
        Book book = obj.getBook(isbn);
        //conver Book t object into json object
        String jsonObj = JsonUtil.javaToJson(book);
        //        return th converted java object into json object to servlet

        return jsonObj;
    }

    public String getBookDetails() {
        return null;
    }
}
