package com.ssafy.hw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.hw.dto.Movie;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieService {

    private Map<Integer, Movie> movieMap = new HashMap<>();

    // TODO: 영화 등록 메서드 - registerMovie(Movie movie)
    // - movieMap에 영화를 저장
    // - "[MovieService] 영화 등록: {title}" 출력
    public void registerMovie(Movie movie) {
    	int id = movie.getId();
    	
    	movieMap.put(id, movie);
    	
    	log.info("[MovieService] 영화 등록: {}", movie.getTitle());
    }
    
    
    // TODO: 영화 조회 메서드 - findMovie(int id)
    // - movieMap에서 영화를 조회하여 반환
    // - "[MovieService] 영화 조회: {title}" 출력
    public Movie findMovie(int id) {
    	Movie movie = movieMap.get(id);
    	
    	log.info("[MovieService] 영화 조회: {}", movie.getTitle());
    	
    	return movie;
    }
    
    
    // TODO: 전체 영화 조회 메서드 - findAllMovies()
    // - 모든 영화를 List로 반환
    // - "[MovieService] 전체 영화 조회: N건" 출력
    public List<Movie> findAllMovies() {
    	log.info("[MovieService] 전체 영화 조회: {}건", movieMap.size());
    	return new ArrayList<>(movieMap.values());
    }
}
