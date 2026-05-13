package com.ssafy.ws.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.dto.Book;

@Repository
public class BookDao {

    private Map<String, Book> books = new HashMap<>();

    // 초기 데이터 (이미지 포함)
    public BookDao() {
        books.put("978-1", new Book("978-1", "Java 기초", "김싸피", 25000, "java-cover.jpg"));
        books.put("978-2", new Book("978-2", "Spring 입문", "박싸피", 32000, "spring-cover.jpg"));
        books.put("978-3", new Book("978-3", "JPA 마스터", "제임스 싸피", 38000, "jpa-cover.jpg"));
        books.put("978-4", new Book("978-4", "좋은 코드", "제임스 싸피", 28000, "clean-cover.jpg"));
    }

    public List<Book> selectAll() {
        return new ArrayList<>(books.values());
    }

    public Book selectOne(String isbn) {
        return books.get(isbn);
    }
}
