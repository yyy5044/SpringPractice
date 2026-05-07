package com.ssafy.hw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.hw.model.dto.Movie;
import com.ssafy.hw.model.dao.MovieDao;

public class MovieService {
    // TODO: MovieDao 필드 선언
	private final MovieDao movieDao;
    
	// TODO: 생성자를 통한 의존성 주입 구현
	@Autowired
	public MovieService(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
    public void registerMovie(Movie movie) {
        // TODO: MovieDao를 통해 영화를 저장하고 등록 완료 메시지 출력
    	movieDao.save(movie);
    	System.out.println("[MovieService] 영화 등록 완료: "+ movie.getTitle()+" ("+movie.getDirector()+")");
    }

    public Movie getMovie(int id) {
        // TODO: MovieDao를 통해 영화 조회
        return movieDao.findById(id);
    }

    public List<Movie> getAllMovies() {
        // TODO: MovieDao를 통해 전체 영화 목록 조회
        return movieDao.findAll();
    }
}
