package com.ssafy.ws.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.dto.Book;

@Repository
public class BookDao {

    private Map<Long, Book> books = new HashMap<>();
    private AtomicLong sequence = new AtomicLong(1);

    public BookDao() {
        Book book1 = new Book(sequence.getAndIncrement(), "978-1", "Java 기초", "김싸피", 25000, "자바 입문서", "java-cover.jpg");
        Book book2 = new Book(sequence.getAndIncrement(), "978-2", "Spring 입문", "박싸피", 32000, "스프링 가이드", "spring-cover.jpg");
        Book book3 = new Book(sequence.getAndIncrement(), "978-3", "JPA 마스터", "제임스 싸피", 38000, "JPA 완벽 가이드", "jpa-cover.jpg");
        Book book4 = new Book(sequence.getAndIncrement(), "978-4", "좋은 코드", "제임스 싸피", 28000, "좋은 코드 작성법", "clean-cover.jpg");

        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
        books.put(book3.getId(), book3);
        books.put(book4.getId(), book4);
    }

    public List<Book> selectAll() {
        return new ArrayList<>(books.values());
    }

    public Book selectById(long id) {
        return books.get(id);
    }

    public void insert(Book book) {
        book.setId(sequence.getAndIncrement());
        books.put(book.getId(), book);
    }

    public void update(Book book) {
        books.put(book.getId(), book);
    }

    public void delete(long id) {
        books.remove(id);
    }
}
