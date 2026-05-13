package com.ssafy.ws.service;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dto.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * 도서 등록
     */
    public int insert(Book book) {
        // TODO: BookDao를 통해 도서를 등록
        return bookDao.insert(book);
    }

    /**
     * 전체 도서 조회
     */
    public List<Book> selectAll() {
        // TODO: BookDao를 통해 모든 도서를 조회
        return bookDao.selectAll();
    }
}
