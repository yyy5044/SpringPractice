package com.ssafy.ws.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;

@Component
public class AppRunner implements ApplicationRunner {
    private final BookService bookService;

    public AppRunner(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=== AOP 예외 처리 테스트 시작 ===");

        // 정상 조회 테스트
        System.out.println("--- 정상 조회 테스트 ---");
        Book book = bookService.findBook("978-89-6848-123-1");
        System.out.println("조회된 도서: " + book);

        // IllegalArgumentException 테스트 (빈 ISBN)
        System.out.println("--- IllegalArgumentException 테스트 (빈 ISBN) ---");
        try {
            bookService.findBook("");
        } catch (IllegalArgumentException e) {
            System.out.println("예외가 호출자에게 전파됨: " + e.getMessage());
        }

        // RuntimeException 테스트 (존재하지 않는 ISBN)
        System.out.println("--- RuntimeException 테스트 (존재하지 않는 ISBN) ---");
        try {
            bookService.findBook("000-00-0000-000-0");
        } catch (RuntimeException e) {
            System.out.println("예외가 호출자에게 전파됨: " + e.getMessage());
        }

        // 도서 등록 예외 테스트 (제목 없음)
        System.out.println("--- 도서 등록 예외 테스트 (제목 없음) ---");
        try {
            bookService.registerBook(new Book("978-89-0000-000-0", null, "박싸피", 25000));
        } catch (IllegalArgumentException e) {
            System.out.println("예외가 호출자에게 전파됨: " + e.getMessage());
        }

        System.out.println("=== AOP 예외 처리 테스트 종료 ===");
    }
}
