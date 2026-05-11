package com.ssafy.ws.service;

import java.sql.SQLException;

import com.ssafy.ws.model.dto.Review;

public interface ReviewService {
    void registReview(Review review) throws SQLException;
    void deleteReview(int reviewNo) throws SQLException;
}
