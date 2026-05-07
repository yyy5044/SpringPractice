package com.ssafy.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ssafy.ws.service.BookService;

@SpringBootApplication
public class FrameworkBackWs032Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FrameworkBackWs032Application.class, args);

        // TODO: BookService Bean을 조회하고 getBookInfo 메서드를 호출하세요.
        BookService bookService = context.getBean(BookService.class);
        bookService.getBookInfo("Good Code");
    }
}
