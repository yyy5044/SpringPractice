package com.ssafy.ws.model.dao;

import org.springframework.stereotype.Repository;

// TODO: @Repository 어노테이션을 사용하여 Bean으로 등록하세요.

/**
 * 도서 저장소 클래스
 * Component Scan을 통해 Bean으로 등록되도록 어노테이션을 추가하세요.
 */
@Repository
public class BookDao {

    /**
     * ISBN으로 도서를 조회합니다.
     * @param isbn 도서 ISBN
     * @return 도서 정보
     */
    public String findByIsbn(String isbn) {
        System.out.println("[BookDao] 도서 조회: " + isbn);
        return "Good Code - 좋은 코드 (33,000원)";
    }
}
