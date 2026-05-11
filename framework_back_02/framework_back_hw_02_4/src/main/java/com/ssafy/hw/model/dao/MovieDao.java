package com.ssafy.hw.model.dao;

import java.util.List;

import com.ssafy.hw.model.dto.Movie;

/**
 * 영화 데이터 접근 인터페이스
 */
public interface MovieDao {

    /**
     * 영화 정보를 저장합니다.
     * @param movie 저장할 영화 정보
     */
    void insert(Movie movie);

    /**
     * ID로 영화 정보를 조회합니다.
     * @param id 조회할 영화 ID
     * @return 조회된 영화 정보, 없으면 null
     */
    Movie select(int id);

    /**
     * 모든 영화 목록을 조회합니다.
     * @return 전체 영화 목록
     */
    List<Movie> selectAll();
}
