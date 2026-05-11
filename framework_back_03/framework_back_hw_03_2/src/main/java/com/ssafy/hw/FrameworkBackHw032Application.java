package com.ssafy.hw;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.hw.model.dto.Movie;
import com.ssafy.hw.service.MovieService;

@SpringBootApplication
public class FrameworkBackHw032Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FrameworkBackHw032Application.class, args);

        System.out.println("========================================");
        System.out.println("  영화 관리 시스템 - Java Config");
        System.out.println("========================================");

        // TODO: context에서 MovieService 빈을 가져오기
        MovieService movieService = ctx.getBean(MovieService.class);
        
        // TODO: 영화 객체를 생성하고 등록하기 (실행 결과 참고)
        movieService.registerMovie(new Movie(1, "꿈의 설계자", "알렉스 싸피", "SF", 148));
        movieService.registerMovie(new Movie(2, "공생의 법칙", "장싸피", "드라마", 132));
        
        // TODO: 전체 영화 목록을 조회하여 출력하기
        System.out.println("=== 영화 목록 조회 ===");
        
        List<Movie> list = movieService.getAllMovies();
        for (Movie m : list) {
        	System.out.println(m);
        }
        
        System.out.println("========================================");
        
    }
}
