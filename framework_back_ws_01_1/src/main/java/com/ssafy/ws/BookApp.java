package com.ssafy.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Logger 관련 import문을 작성하세요

import com.ssafy.ws.model.dto.Book;

public class BookApp {

    // TODO: Logger 객체를 생성하세요
	static final Logger log = LoggerFactory.getLogger(BookApp.class);
	
    public static void main(String[] args) {
        // TODO: 시스템 시작 로그를 출력하세요 (INFO)
    	log.info("=== SSAFY 도서관 시스템 시작 ===");
    	
        // 도서 생성 및 로깅
        Book book1 = new Book("978-1", "Java 기초", "김싸피", 25000);
        logBook(book1);

        Book book2 = new Book("978-2", "Spring 마스터", "박싸피", 45000);
        logBook(book2);

        // TODO: 시스템 종료 로그를 출력하세요 (INFO)
        log.info("=== 시스템 종료 ===");
    }

    private static void logBook(Book book) {
        // TODO: 도서 등록 로그를 출력하세요 (INFO)
    	
        // TODO: 도서 가격 로그를 출력하세요 (DEBUG)
    	
        // TODO: 고가 도서 경고를 출력하세요 (WARN)
    	
        // 조건: 가격이 30,000원을 초과하는 경우
    }
}
