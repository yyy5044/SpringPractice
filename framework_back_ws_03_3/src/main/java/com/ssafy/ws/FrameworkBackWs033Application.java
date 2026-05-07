package com.ssafy.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ssafy.ws.service.BookService;

@SpringBootApplication
public class FrameworkBackWs033Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FrameworkBackWs033Application.class, args);

        // BookService Bean 조회 및 사용
        BookService bookService = context.getBean(BookService.class);
        bookService.getBookInfo("ISBN-001");
    }
}
