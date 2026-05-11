package com.ssafy.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ssafy.ws.service.BookService;

@SpringBootApplication
public class FrameworkBackWs042Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FrameworkBackWs042Application.class, args);

        BookService bookService = context.getBean(BookService.class);

        System.out.println("=== @Before 로깅 테스트 ===");
        bookService.registerBook("978-89-6848-123-1", "Java 프로그래밍", 30000);
        System.out.println();
        bookService.findBook("978-89-6848-123-1");
    }
}
