package com.ssafy.hw.service;

import java.util.List;

import com.ssafy.hw.model.dto.Movie;

/**
 * 영화 서비스 인터페이스
 */
public interface MovieService {

    /**
     * 영화를 등록합니다.
     * @param movie 등록할 영화 정보
     * @return 등록 성공 여부
     */
    boolean registerMovie(Movie movie);

    /**
     * ID로 영화를 조회합니다.
     * @param id 조회할 영화 ID
     * @return 조회된 영화 정보
     */
    Movie getMovie(int id);

    /**
     * 모든 영화를 조회합니다.
     * @return 전체 영화 목록
     */
    List<Movie> getAllMovies();
}
