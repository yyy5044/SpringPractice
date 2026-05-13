package com.ssafy.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dao.BookDao;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.selectAll();
    }

    public Book getBook(String isbn) {
        return bookDao.selectOne(isbn);
    }
}
