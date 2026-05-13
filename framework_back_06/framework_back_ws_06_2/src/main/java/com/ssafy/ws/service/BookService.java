package com.ssafy.ws.service;

import java.util.List;

import com.ssafy.ws.model.dto.Book;

/**
 * 도서 서비스 인터페이스
 */
public interface BookService {

    /**
     * 전체 도서 목록 조회
     */
    List<Book> selectAll();

    /**
     * 도서 상세 조회
     */
    Book selectById(long id);

    /**
     * 도서 등록
     */
    void insert(Book book);

    /**
     * 도서 수정
     */
    void update(Book book);

    /**
     * 도서 삭제
     */
    void delete(long id);
}
