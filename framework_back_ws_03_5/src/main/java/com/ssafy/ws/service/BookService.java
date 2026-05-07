package com.ssafy.ws.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.Review;

public interface BookService {
    void registBook(Book book) throws SQLException;
    Book getBook(String isbn) throws SQLException;
    List<Book> getAllBooks() throws SQLException;
    void updateBook(Book book) throws SQLException;
    void deleteBook(String isbn) throws SQLException;
    List<Review> getReviews(String isbn) throws SQLException;
}
