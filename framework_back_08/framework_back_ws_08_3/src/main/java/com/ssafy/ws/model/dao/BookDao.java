package com.ssafy.ws.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.dto.Book;

/**
 * 8-3: 수정 - BookDao 인터페이스
 *
 * 실습 과제: UPDATE 문을 이용한 수정 기능 구현
 * (SELECT + INSERT + UPDATE = CRU)
 */
@Mapper
public interface BookDao {

    // ============ READ (8-1에서 학습) ============
    List<Book> selectAll();
    Book select(String isbn);

    // ============ CREATE (8-2에서 학습) ============
    int insert(Book book);

    // ============ UPDATE (8-3 실습) ============
    // TODO: 책 정보 수정 메서드를 선언하세요.
    // - 메서드명: update
    // - 파라미터: Book book
    // - 반환값: int (수정된 행 수)
    int update(Book book);

}
