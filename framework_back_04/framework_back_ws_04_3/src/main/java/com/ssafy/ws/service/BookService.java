package com.ssafy.ws.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Book;

@Service
public class BookService {

    public List<Book> findAll() {
        System.out.println("BookService.findAll() 실행됨");
        return Arrays.asList(
            new Book("978-89-6848-123-1", "Java 프로그래밍", "김싸피", 30000),
            new Book("978-89-6848-456-2", "Spring 입문", "이자바", 35000),
            new Book("978-89-6848-789-3", "알고리즘", "박코딩", 28000)
        );
    }

    public Book findByIsbn(String isbn) {
        System.out.println("BookService.findByIsbn(" + isbn + ") 실행됨");
        if ("978-89-6848-123-1".equals(isbn)) {
            return new Book("978-89-6848-123-1", "Java 프로그래밍", "김싸피", 30000);
        }
        return null;
    }

    public void save(Book book) {
        System.out.println("BookService.save(" + book + ") 실행됨");
    }
}
