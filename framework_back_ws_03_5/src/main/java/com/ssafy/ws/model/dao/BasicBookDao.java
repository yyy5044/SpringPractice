package com.ssafy.ws.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.dto.Book;

@Repository
public class BasicBookDao implements BookDao {
    private static BasicBookDao dao = new BasicBookDao();

    private BasicBookDao() {}

    public static BasicBookDao getDao() {
        return dao;
    }

    @Override
    public int insert(Connection con, Book book) throws SQLException {
        String sql = "INSERT INTO book (isbn, title, author, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setInt(4, book.getPrice());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public Book select(Connection con, String isbn) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM book WHERE isbn = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
            }
        }
        return book;
    }

    @Override
    public List<Book> selectAll(Connection con) throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book ORDER BY isbn";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                list.add(book);
            }
        }
        return list;
    }

    @Override
    public int update(Connection con, Book book) throws SQLException {
        String sql = "UPDATE book SET title = ?, author = ?, price = ? WHERE isbn = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPrice());
            pstmt.setString(4, book.getIsbn());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Connection con, String isbn) throws SQLException {
        String sql = "DELETE FROM book WHERE isbn = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            return pstmt.executeUpdate();
        }
    }
}
