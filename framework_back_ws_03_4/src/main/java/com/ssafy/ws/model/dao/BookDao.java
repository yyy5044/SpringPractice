package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Book;

public interface BookDao {
    int insert(Book book);
    Book select(String isbn);
    List<Book> selectAll();
    int update(Book book);
    int delete(String isbn);
}
