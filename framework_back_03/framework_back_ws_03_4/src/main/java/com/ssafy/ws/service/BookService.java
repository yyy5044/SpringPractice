package com.ssafy.ws.service;

import java.util.List;

import com.ssafy.ws.model.dto.Book;

public interface BookService {
    int insert(Book book);
    Book select(String isbn);
    List<Book> selectAll();
    int update(Book book);
    int delete(String isbn);
}
