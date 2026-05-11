package com.ssafy.ws.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.dto.Book;

@Repository
public class BookDaoImpl implements BookDao {

    private Map<String, Book> books = new HashMap<>();

    @Override
    public int insert(Book book) {
        if (books.containsKey(book.getIsbn())) {
            return 0;
        }
        books.put(book.getIsbn(), book);
        return 1;
    }

    @Override
    public Book select(String isbn) {
        return books.get(isbn);
    }

    @Override
    public List<Book> selectAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public int update(Book book) {
        if (!books.containsKey(book.getIsbn())) {
            return 0;
        }
        books.put(book.getIsbn(), book);
        return 1;
    }

    @Override
    public int delete(String isbn) {
        if (books.remove(isbn) != null) {
            return 1;
        }
        return 0;
    }
}
