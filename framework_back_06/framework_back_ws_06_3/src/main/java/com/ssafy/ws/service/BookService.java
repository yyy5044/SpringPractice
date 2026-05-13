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

    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    public Book selectById(long id) {
        return bookDao.selectById(id);
    }

    public void insert(Book book) {
        bookDao.insert(book);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(long id) {
        bookDao.delete(id);
    }
}
