package com.ssafy.ws.service;

import com.ssafy.ws.model.dao.BookDao;

/**
 * 도서 서비스 클래스
 */
public class BookService {

    // TODO: BookDao 필드를 선언하세요.
	private final BookDao bookDao;

    /**
     * 생성자를 통한 의존성 주입
     *
     * TODO: BookDao를 파라미터로 받는 생성자를 작성하세요.
     */
	public BookService(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
    /**
     * 도서 정보를 조회합니다.
     * @param title 도서명
     */
    public void getBookInfo(String title) {
        // TODO: bookDao.findByTitle(title)을 호출하여 결과를 출력하세요.
        // 출력 형식: "[BookService] 도서 정보: " + bookInfo
    	System.out.println("[BookService] 도서 정보: " + bookDao.findByTitle(title));
    }
}
