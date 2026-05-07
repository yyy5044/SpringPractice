package com.ssafy.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: 필요한 import 문을 추가하세요.
// TODO: @Service 어노테이션을 사용하여 Bean으로 등록하세요.

import com.ssafy.ws.model.dao.BookDao;

/**
 * 도서 서비스 클래스
 * Component Scan을 통해 Bean으로 등록되도록 어노테이션을 추가하세요.
 */
@Service
public class BookService {

    private final BookDao bookDao;

    /**
     * 생성자를 통한 의존성 주입
     * TODO: @Autowired 어노테이션을 추가하세요.
     * @param bookDao 도서 저장소
     */
    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * 도서 정보를 조회합니다.
     * @param isbn 도서 ISBN
     */
    public void getBookInfo(String isbn) {
        String bookInfo = bookDao.findByIsbn(isbn);
        System.out.println("[BookService] 도서 정보: " + bookInfo);
    }
}
