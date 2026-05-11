package com.ssafy.ws.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.model.dto.Review;

public interface ReviewDao {
    int insert(Connection con, Review review) throws SQLException;
    List<Review> selectByIsbn(Connection con, String isbn) throws SQLException;
    int delete(Connection con, int reviewNo) throws SQLException;
    int deleteByIsbn(Connection con, String isbn) throws SQLException;
}
