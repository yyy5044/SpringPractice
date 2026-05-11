package com.ssafy.ws.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.model.dto.Book;

public interface BookDao {
    int insert(Connection con, Book book) throws SQLException;
    Book select(Connection con, String isbn) throws SQLException;
    List<Book> selectAll(Connection con) throws SQLException;
    int update(Connection con, Book book) throws SQLException;
    int delete(Connection con, String isbn) throws SQLException;
}
