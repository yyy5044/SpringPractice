package com.ssafy.ws.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dto.Book;

@Service
public class BookService {

    private Map<String, Book> bookRepository = new HashMap<>();

    public BookService() {
        bookRepository.put("978-89-6848-123-1", new Book("978-89-6848-123-1", "Java 프로그래밍", "김싸피", 30000));
        bookRepository.put("978-89-6848-456-2", new Book("978-89-6848-456-2", "Spring 입문", "이자바", 35000));
        bookRepository.put("978-89-6848-789-3", new Book("978-89-6848-789-3", "알고리즘", "박코딩", 28000));
    }

    public Book findBook(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN은 필수입니다.");
        }
        Book book = bookRepository.get(isbn);
        if (book == null) {
            throw new RuntimeException("도서를 찾을 수 없습니다: " + isbn);
        }
        return book;
    }

    public void registerBook(Book book) {
        if (book.getTitle() == null) {
            throw new IllegalArgumentException("도서 제목은 필수입니다.");
        }
        bookRepository.put(book.getIsbn(), book);
    }
}
