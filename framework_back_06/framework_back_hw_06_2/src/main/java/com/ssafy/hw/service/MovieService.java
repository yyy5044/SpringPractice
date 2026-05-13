package com.ssafy.hw.service;

import java.util.List;

import com.ssafy.hw.dto.Movie;

/**
 * 영화 서비스 인터페이스
 */
public interface MovieService {

    List<Movie> selectAll();

    void insert(Movie movie);
}
