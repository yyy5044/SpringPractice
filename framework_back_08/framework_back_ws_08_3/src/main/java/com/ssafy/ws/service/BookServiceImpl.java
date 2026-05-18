package com.ssafy.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public Book select(String isbn) {
        return bookDao.select(isbn);
    }

    @Override
    public void insert(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void update(Book book) {
        // TODO: 구현하세요
    	bookDao.update(book);
    }
}
