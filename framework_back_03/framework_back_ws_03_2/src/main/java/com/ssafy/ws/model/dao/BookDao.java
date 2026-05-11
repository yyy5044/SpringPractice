package com.ssafy.ws.model.dao;

/**
 * 도서 저장소 클래스
 */
public class BookDao {

    /**
     * 도서명으로 도서를 조회합니다.
     * @param title 도서명
     * @return 도서 정보
     */
    public String findByTitle(String title) {
        // TODO: 도서 조회 메시지를 출력하고 도서 정보를 반환하세요.
        // 출력 형식: "[BookDao] 도서 조회: " + title
        // 반환 형식: title + " - 프로그래밍 도서"
    	System.out.println("[BookDao] 도서 조회: " + title);
        return title+" - 프로그래밍 도서";
    }
}
