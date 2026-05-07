package com.ssafy.ws.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;

@Component
public class AppRunner implements CommandLineRunner {

    private final BookService bookService;

    public AppRunner(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("========================================");
        System.out.println("  의존성 자동 주입 테스트");
        System.out.println("========================================");

        // 도서 등록
        Book book1 = new Book("978-89-1234-001", "스프링 부트 입문", "김스프링", 28000);
        Book book2 = new Book("978-89-1234-002", "자바 프로그래밍", "이자바", 32000);

        bookService.insert(book1);
        System.out.println("[BookService] 도서 등록 완료: " + book1.getTitle());

        bookService.insert(book2);
        System.out.println("[BookService] 도서 등록 완료: " + book2.getTitle());

        // 도서 조회
        Book found = bookService.select("978-89-1234-001");
        System.out.println("[BookService] 도서 조회 결과: " + found);

        // 전체 도서 조회
        System.out.println("[BookService] 전체 도서 목록:");
        for (Book book : bookService.selectAll()) {
            System.out.println("  - " + book);
        }

        System.out.println("========================================");
    }
}
