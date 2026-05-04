package com.ssafy.ws.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

import com.ssafy.ws.model.dto.Book;

class BookTest {

    private static final Logger logger = LoggerFactory.getLogger(BookTest.class);

    @Test
    @DisplayName("Book 객체 생성 테스트")
    void testBookCreation() {
        // given
        String isbn = "978-1";
        String title = "Java 기초";
        String author = "홍길동";
        int price = 25000;

        // when
        Book book = new Book(isbn, title, author, price);

        // then
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
        Book book = new Book();

        // when
        book.setIsbn("978-2");
        book.setTitle("Spring 입문");
        book.setAuthor("김영희");
        book.setPrice(32000);

        // then
        assertEquals("978-2", book.getIsbn());
        assertEquals("Spring 입문", book.getTitle());
        assertEquals("김영희", book.getAuthor());
        assertEquals(32000, book.getPrice());
    }

    @Test
    @DisplayName("toString 출력 테스트")
    void testBookToString() {
        // given
        Book book = new Book("978-1", "Java 기초", "홍길동", 25000);

        // when
        String result = book.toString();

        // then
        assertTrue(result.contains("Java 기초"));
        assertTrue(result.contains("홍길동"));
        assertTrue(result.contains("25000"));
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

        // TODO: 예외 메시지에 "0 이상"이 포함되어 있는지 assertTrue로 검증하세요.

    }

    @Test
    @DisplayName("고가 도서 경고 로그 테스트")
    void testPriceWarningLog() {
        // given
        Book book = new Book("978-1", "고급 전문서", "전문가", 50000);

        // when
        // TODO: 가격이 30000원 초과이면 logLevel = "WARN", 그 외에는 "INFO"로 설정하세요.
        // 해당 조건에 맞는 로그도 출력하세요. (logger.warn 또는 logger.info)
        String logLevel = null;

        // then
        assertEquals("WARN", logLevel);
    }
}
