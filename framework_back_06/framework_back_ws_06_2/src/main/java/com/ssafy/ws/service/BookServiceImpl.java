package com.ssafy.ws.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dto.Book;

/**
 * 도서 서비스 구현체 (메모리 기반)
 */
@Service
public class BookServiceImpl implements BookService {

    private Map<Long, Book> bookStore = new HashMap<>();
    private AtomicLong idGenerator = new AtomicLong(1);

    // 초기 데이터
    public BookServiceImpl() {
        Book book1 = new Book(idGenerator.getAndIncrement(), "978-89-12345-01-0",
                "Spring Boot 입문", "김싸피", 25000, "스프링 부트 기초 학습서", null);
        Book book2 = new Book(idGenerator.getAndIncrement(), "978-89-12345-02-0",
                "Java 프로그래밍", "김싸피", 30000, "자바 완벽 가이드", null);
        bookStore.put(book1.getId(), book1);
        bookStore.put(book2.getId(), book2);
    }

    @Override
    public List<Book> selectAll() {
        return new ArrayList<>(bookStore.values());
    }

    @Override
    public Book selectById(long id) {
        return bookStore.get(id);
    }

    @Override
    public void insert(Book book) {
        book.setId(idGenerator.getAndIncrement());
        bookStore.put(book.getId(), book);
    }

    @Override
    public void update(Book book) {
        bookStore.put(book.getId(), book);
    }

    @Override
    public void delete(long id) {
        bookStore.remove(id);
    }
}
