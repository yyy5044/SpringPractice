package com.ssafy.ws.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BasicBookDao;
import com.ssafy.ws.model.dao.BasicReviewDao;
import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dao.ReviewDao;
import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.Review;
import com.ssafy.ws.util.DBUtil;

@Service
public class BasicBookService implements BookService {
    private BookDao bookDao;
    private ReviewDao reviewDao;
    private DBUtil util;
    
    public BasicBookService(BookDao bookDao, ReviewDao reviewDao, DBUtil util) {
    	this.bookDao = bookDao;
    	this.reviewDao = reviewDao;
    	this.util = util;
    }

    @Override
    public void registBook(Book book) throws SQLException {
        Connection con = util.getConnection();
        try {
            con.setAutoCommit(false);
            bookDao.insert(con, book);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            util.close(con);
        }
    }

    @Override
    public Book getBook(String isbn) throws SQLException {
        try (Connection con = util.getConnection()) {
            return bookDao.select(con, isbn);
        }
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {
        try (Connection con = util.getConnection()) {
            return bookDao.selectAll(con);
        }
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        Connection con = util.getConnection();
        try {
            con.setAutoCommit(false);
            bookDao.update(con, book);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            util.close(con);
        }
    }

    @Override
    public void deleteBook(String isbn) throws SQLException {
        Connection con = util.getConnection();
        try {
            con.setAutoCommit(false);
            reviewDao.deleteByIsbn(con, isbn);
            bookDao.delete(con, isbn);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            util.close(con);
        }
    }

    @Override
    public List<Review> getReviews(String isbn) throws SQLException {
        try (Connection con = util.getConnection()) {
            return reviewDao.selectByIsbn(con, isbn);
        }
    }
}
