package com.ssafy.hw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.hw.model.dto.Movie;

public class MovieApp {

    private static final Logger logger = LoggerFactory.getLogger(MovieApp.class);

    public static void main(String[] args) {
        logger.info("=== SSAFY Cinema 시스템 시작 ===");

        // TODO: Movie 객체를 생성하세요.
        // movie1: id=1, title="공생의 법칙", director="장싸피", genre="드라마", runningTime=132
        // movie2: id=2, title="푸른 행성", director="데이빗 싸피", genre="SF", runningTime=162
        Movie movie1 = new Movie(1, "공생의 법칙", "장싸피", "드라마", 132);
        Movie movie2 = new Movie(2, "푸른 행성", "데이빗 싸피", "SF", 162);

        logger.info("영화 등록: {}", movie1);
        logger.info("영화 등록: {}", movie2);

        // TODO: checkRunningTimeWarning 메서드를 호출하세요.
        checkRunningTimeWarning(movie1);
        checkRunningTimeWarning(movie2);
        
        logger.info("=== 시스템 종료 ===");
    }

    private static void checkRunningTimeWarning(Movie movie) {
        // TODO: 상영 시간이 150분 초과이면 WARN 레벨로 "장시간 영화 주의" 로그를 출력하세요.
        // 그 외에는 INFO 레벨로 "일반 영화" 로그를 출력하세요.
        // 형식: "{제목} ({상영시간}분)"
    	int runningTime = movie.getRunningTime();
    	if (runningTime > 150) {
    		logger.warn("장시간 영화 주의: {} ({}분)", movie.getTitle(), runningTime);
    	} else {
    		logger.info("일반 영화: {} ({}분)", movie.getTitle(), runningTime);
    	}
    }
}
