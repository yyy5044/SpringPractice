package com.ssafy.hw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ssafy.hw.model.dto.Movie;
import com.ssafy.hw.service.MovieService;

/**
 * 영화 관리 클래스
 *
 * TODO: @Component 어노테이션을 확인하세요. (이미 추가되어 있음)
 *
 * 이 클래스는 @Qualifier를 사용하여 koreaMovieService를 선택적으로 주입받습니다.
 */
@Component
public class MovieManager {

    // TODO: MovieService 필드를 선언하세요.
	private final MovieService movieService;
	
    // TODO: @Autowired와 @Qualifier를 사용하여 koreaMovieService를 주입받는 생성자를 작성하세요.
    // - 생성자 주입 방식을 사용합니다.
    // - @Qualifier로 주입받을 빈의 이름을 지정합니다.
	@Autowired
	public MovieManager(@Qualifier("koreaMovieService") MovieService movieService) {
		this.movieService = movieService;
	}
	
    /**
     * 영화를 등록합니다.
     * @param movie 등록할 영화
     */
    public void addMovie(Movie movie) {
        // TODO: movieService를 사용하여 영화를 등록하세요.
    	movieService.registerMovie(movie);
    }

    /**
     * ID로 영화를 조회합니다.
     * @param id 조회할 영화 ID
     * @return 조회된 영화
     */
    public Movie findMovie(int id) {
        // TODO: movieService를 사용하여 영화를 조회하세요.
        return movieService.getMovie(id);
    }

    /**
     * 모든 영화를 조회합니다.
     * @return 전체 영화 목록
     */
    public List<Movie> findAllMovies() {
        // TODO: movieService를 사용하여 모든 영화를 조회하세요.
        return movieService.getAllMovies();
    }
}
