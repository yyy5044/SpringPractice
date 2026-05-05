package com.ssafy.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.ws.model.dto.Book;

public class BookApp {

    private static final Logger logger = LoggerFactory.getLogger(BookApp.class);

    public static void main(String[] args) {
        logger.info("=== SSAFY 도서관 시스템 시작 ===");

        Book book1 = new Book("978-1", "Java 기초", "홍길동", 25000);
        Book book2 = new Book("978-2", "Spring 마스터", "김영희", 45000);

        logger.info("도서 등록: {}", book1);
        logger.info("도서 등록: {}", book2);

        // TODO: checkPriceWarning 메서드를 호출하여 조건부 로깅을 테스트하세요.
        checkPriceWarning(book1);
        checkPriceWarning(book2);
        // TODO: 음수 가격으로 Book 생성을 시도하고 예외를 catch하여 로그로 출력하세요.
        try {
        	Book book3 = new Book("978-3", "DB 마스터", "오양호", -100000);
        } catch(Exception e) {
        	logger.error(e.getMessage());
        }
        
        logger.info("=== 시스템 종료 ===");
    }

    private static void checkPriceWarning(Book book) {
        // TODO: 가격이 30000원 초과이면 WARN, 그 외에는 INFO 레벨로 로그를 출력하세요.
    	int price = book.getPrice();
    	if (price > 30000) {
    		logger.warn("고가 도서 경고: {} ({}원)", book.getTitle(), price);
    	} else {
    		logger.info("일반 도서: {} ({}원)", book.getTitle(), price);
    	}
        // WARN: "고가 도서 경고: {제목} ({가격}원)"
        // INFO: "일반 도서: {제목} ({가격}원)"

    }
}
