package com.ssafy.ws.test;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import com.ssafy.ws.model.dto.Book;

class BookTest {

    @Test
    @DisplayName("Book 객체 생성 테스트")
    void testBookCreation() {
        // given
        String isbn = "978-1";
        String title = "Java 기초";
        String author = "김싸피";
        int price = 25000;

        // when
        // TODO: Book 객체를 전체 필드 생성자로 생성하세요.
        Book book = new Book(isbn, title, author, price);

        // then
        // TODO: assertNotNull, assertEquals를 사용하여 객체와 각 필드를 검증하세요.
        assertNotNull(book);
        assertEquals(isbn, book.getIsbn());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(price, book.getPrice());
    }

    @Test
    @DisplayName("Getter/Setter 동작 테스트")
    void testBookGetterSetter() {
        // given
        // TODO: 기본 생성자로 Book 객체를 생성하세요.
        Book book = new Book();

        // when
        // TODO: Setter 메서드를 사용하여 각 필드 값을 설정하세요.
        // isbn: "978-2", title: "Spring 입문", author: "박싸피", price: 32000
        book.setIsbn("978-2");
        book.setTitle("Spring 입문");
        book.setAuthor("박싸피");
        book.setPrice(32000);
        
        // then
        // TODO: assertEquals를 사용하여 Getter로 값을 검증하세요.
        assertEquals("978-2", book.getIsbn());
        assertEquals("Spring 입문", book.getTitle());
        assertEquals("박싸피", book.getAuthor());
        assertEquals(32000, book.getPrice());
    }

    @Test
    @DisplayName("toString 출력 테스트")
    void testBookToString() {
        // given
        Book book = new Book("978-1", "Java 기초", "김싸피", 25000);

        // when
        // TODO: toString() 메서드를 호출하여 결과를 저장하세요.
        String result = book.toString();

        // then
        // TODO: assertTrue와 contains를 사용하여 문자열에 필드 값이 포함되어 있는지 검증하세요.
        assertAll("assertAll 사용해보기",
        	() -> assertTrue(result.contains(book.getIsbn())),
        	() -> assertTrue(result.contains(book.getTitle())),
        	() -> assertTrue(result.contains(book.getAuthor())),
        	() -> assertTrue(result.contains(String.valueOf(book.getPrice())))
        );
    }
    
    @Test
    @DisplayName("음수 가격 설정 시 예외 발생")
    void testNegativePriceThrowsException() {
        // given
        Book book = new Book();

        // when & then
        // TODO: assertThrows를 사용하여 book.setPrice(-1000) 호출 시
        // IllegalArgumentException이 발생하는지 검증하세요.
        // 힌트: assertThrows(예외클래스.class, () -> 실행코드)
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, 
        											() -> book.setPrice(-1000));
        
        // TODO: 예외 메시지에 "0 이상"이 포함되어 있는지 assertTrue로 검증하세요.
        assertTrue(e.getMessage().contains("0 이상"));
    }
    
    @Test
    @DisplayName("고가 도서 경고 로그 테스트")
    void testPriceWarningLog() {
        // given
        Book book = new Book("978-1", "고급 전문서", "전문가", 50000);

        Logger logger = LoggerFactory.getLogger(BookTest.class);
        // when
        // TODO: 가격이 30000원 초과이면 logLevel = "WARN", 그 외에는 "INFO"로 설정하세요.
        // 해당 조건에 맞는 로그도 출력하세요. (logger.warn 또는 logger.info)
        String logLevel = null;
        if (book.getPrice() > 30000) {
        	logLevel = "WARN";
        	logger.warn("고가 도서 경고: {} ({}원)", book.getTitle(), book.getPrice());
        } else {
        	logLevel = "INFO";
        	logger.info("도서 등록: {}", book);
        }

        // then
        assertEquals("WARN", logLevel);
    }
}
