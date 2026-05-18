package com.ssafy.ws.service;

import java.util.List;

import com.ssafy.ws.model.dto.Book;

public interface BookService {

    List<Book> selectAll();

    Book select(String isbn);

    void insert(Book book);

    void update(Book book);
}
