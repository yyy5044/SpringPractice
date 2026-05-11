package com.ssafy.ws;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.service.BookService;

@SpringBootApplication
public class FrameworkBackWs043Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FrameworkBackWs043Application.class, args);

        BookService bookService = context.getBean(BookService.class);

        // findAll 테스트 - List 반환
        List<Book> books = bookService.findAll();
        System.out.println();

        // findByIsbn 테스트 - 존재하는 도서
        Book book = bookService.findByIsbn("978-89-6848-123-1");
        System.out.println();

        // findByIsbn 테스트 - 존재하지 않는 도서 (null 반환)
        Book notFound = bookService.findByIsbn("000-00-0000-000-0");
        System.out.println();

        // save 테스트
        Book newBook = new Book("978-89-6848-999-9", "Python 입문", "최파이", 25000);
        bookService.save(newBook);
    }
}
