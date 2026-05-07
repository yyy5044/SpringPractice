package com.ssafy.ws.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.dto.Review;

@Repository
public class BasicReviewDao implements ReviewDao {
    private static BasicReviewDao dao = new BasicReviewDao();

    private BasicReviewDao() {}

    public static BasicReviewDao getDao() {
        return dao;
    }

    @Override
    public int insert(Connection con, Review review) throws SQLException {
        String sql = "INSERT INTO review (isbn, content, score) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, review.getIsbn());
            pstmt.setString(2, review.getContent());
            pstmt.setInt(3, review.getScore());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public List<Review> selectByIsbn(Connection con, String isbn) throws SQLException {
        List<Review> list = new ArrayList<>();
        String sql = "SELECT * FROM review WHERE isbn = ? ORDER BY review_no";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setReviewNo(rs.getInt("review_no"));
                review.setIsbn(rs.getString("isbn"));
                review.setContent(rs.getString("content"));
                review.setScore(rs.getInt("score"));
                list.add(review);
            }
        }
        return list;
    }

    @Override
    public int delete(Connection con, int reviewNo) throws SQLException {
        String sql = "DELETE FROM review WHERE review_no = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, reviewNo);
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int deleteByIsbn(Connection con, String isbn) throws SQLException {
        String sql = "DELETE FROM review WHERE isbn = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            return pstmt.executeUpdate();
        }
    }
}
