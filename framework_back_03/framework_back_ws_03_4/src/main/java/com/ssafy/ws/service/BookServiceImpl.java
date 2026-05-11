package com.ssafy.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {

    // TODO: BookDao를 final 필드로 선언하고, 생성자 주입을 구현하세요.
    // 힌트: 생성자가 하나인 경우 @Autowired 생략 가능 (Spring 4.3+)

    private final BookDao bookDao;
    
    // @Autowired 생략 가능
    public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

    @Override
    public int insert(Book book) {
        return bookDao.insert(book);
    }

    @Override
    public Book select(String isbn) {
        return bookDao.select(isbn);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public int delete(String isbn) {
        return bookDao.delete(isbn);
    }
}
