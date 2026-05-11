package com.ssafy.hw.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ssafy.hw.dto.Movie;
import com.ssafy.hw.service.MovieService;

@Component
public class AppRunner implements CommandLineRunner {

    private final MovieService movieService;

    public AppRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("========================================");
        System.out.println("  영화 서비스 - AOP 로깅");
        System.out.println("========================================");
        
        // 영화 등록
        Movie movie1 = new Movie(1, "꿈의 설계자", "알렉스 싸피", "SF", 148);
        movieService.registerMovie(movie1);

        Movie movie2 = new Movie(2, "별의 항해", "알렉스 싸피", "SF", 169);
        movieService.registerMovie(movie2);

        // 영화 조회
        movieService.findMovie(1);

        // 전체 영화 조회
        movieService.findAllMovies();

        System.out.println("========================================");
    }
}
