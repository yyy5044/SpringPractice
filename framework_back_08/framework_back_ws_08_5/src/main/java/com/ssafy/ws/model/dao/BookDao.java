package com.ssafy.ws.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.dto.Book;

/**
 * 8-5: 설정 - BookDao 인터페이스
 *
 * ResultMap을 이용한 컬럼-필드 매핑 학습
 */
@Mapper
public interface BookDao {

    /**
     * 모든 책 목록 조회 (ResultMap 사용)
     */
    List<Book> selectAll();

    /**
     * ISBN으로 책 조회 (ResultMap 사용)
     */
    Book select(String isbn);

    int insert(Book book);
    int update(Book book);
    int delete(String isbn);
}
