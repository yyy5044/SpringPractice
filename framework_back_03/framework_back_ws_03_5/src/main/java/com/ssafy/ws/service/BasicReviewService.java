package com.ssafy.ws.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BasicReviewDao;
import com.ssafy.ws.model.dao.ReviewDao;
import com.ssafy.ws.model.dto.Review;
import com.ssafy.ws.util.DBUtil;

@Service
public class BasicReviewService implements ReviewService {
	private ReviewDao reviewDao;
    private DBUtil util;
    
    public BasicReviewService(ReviewDao reviewDao, DBUtil util) {
    	this.reviewDao = reviewDao;
    	this.util = util;
	}

    @Override
    public void registReview(Review review) throws SQLException {
        Connection con = util.getConnection();
        try {
            con.setAutoCommit(false);
            reviewDao.insert(con, review);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            util.close(con);
        }
    }

    @Override
    public void deleteReview(int reviewNo) throws SQLException {
        Connection con = util.getConnection();
        try {
            con.setAutoCommit(false);
            reviewDao.delete(con, reviewNo);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            util.close(con);
        }
    }
}
