package com.ssafy.hw.service;

import java.util.List;

import com.ssafy.hw.model.dto.Movie;

/**
 * 영화 서비스 인터페이스
 */
public interface MovieService {

    List<Movie> selectAll();

    Movie findById(int id);

    List<Movie> searchByTitle(String title);

    List<Movie> searchByDirector(String director);

    List<Movie> searchByType(String searchType, String keyword);

    List<Movie> searchWithSort(String keyword, String orderBy, String orderDir);
}
