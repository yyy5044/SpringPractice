package com.ssafy.hw.service;

//TODO: 필요한 import 문을 추가하세요.
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hw.model.dao.MovieDao;
import com.ssafy.hw.model.dto.Movie;



/**
 * 글로벌 영화 서비스 구현체
 *
 * TODO: @Service 어노테이션을 추가하고 빈 이름을 "globalMovieService"로 지정하세요.
 */
@Service("globalMovieService")
public class GlobalMovieService implements MovieService {

    // TODO: MovieDao 필드를 선언하세요.
	private final MovieDao movieDao;
	
    // TODO: 생성자 주입을 위한 생성자를 작성하세요.
    // Hint: @Autowired 어노테이션을 사용하세요.
	@Autowired
	public GlobalMovieService(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
    @Override
    public boolean registerMovie(Movie movie) {
        // TODO: runningTime이 0 이하인 경우 등록을 거부하고 에러 메시지를 출력하세요.
        // TODO: 글로벌 영화 표시를 위해 제목에 "[글로벌] " 접두사를 추가하세요.
        // TODO: movieDao.insert()를 호출하여 영화를 저장하세요.
        // TODO: 등록 메시지를 출력하세요.
    	int runningTime = movie.getRunningTime();
    	if (runningTime <= 0) {
    		System.err.println("유효하지 않은 상영 시간입니다.");
    		return false;
    	}
    	
    	movie.setTitle("[글로벌] "+movie.getTitle());
    	
    	movieDao.insert(movie);
    	System.out.println("[글로벌] 영화 등록: "+movie);
    	
        return true;
    }

    @Override
    public Movie getMovie(int id) {
        // TODO: movieDao를 사용하여 영화를 조회하세요.
        return movieDao.select(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        // TODO: movieDao를 사용하여 모든 영화를 조회하세요.
        return movieDao.selectAll();
    }
}
