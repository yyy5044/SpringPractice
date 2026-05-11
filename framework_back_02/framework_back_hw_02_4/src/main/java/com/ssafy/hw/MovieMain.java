package com.ssafy.hw;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.hw.config.MovieConfig;
import com.ssafy.hw.model.dto.Movie;
import com.ssafy.hw.service.GlobalMovieService;
import com.ssafy.hw.service.MovieService;

/**
 * @Qualifier 테스트를 위한 메인 클래스
 */
public class MovieMain {

    public static void main(String[] args) {
        // TODO: AnnotationConfigApplicationContext를 사용하여 Spring 컨테이너를 초기화하세요.
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MovieConfig.class);
    	
        // TODO: MovieManager 빈을 획득하세요.
        // - context.getBean() 메서드를 사용합니다.
        // - MovieManager는 koreaMovieService가 주입된 상태입니다.
    	MovieManager movieManager = ctx.getBean(MovieManager.class);
    	
        System.out.println("=== MovieManager를 통한 영화 등록 ===");
        // TODO: 영화를 생성하고 MovieManager를 통해 등록하세요.
        // 예: new Movie(1, "공생의 법칙", "장싸피", "드라마", 132)
        Movie movie1 = new Movie(1, "공생의 법칙", "장싸피", "드라마", 132);
        Movie movie2 = new Movie(2, "복수의 시간", "윤싸피", "스릴러", 120);
        
        movieManager.addMovie(movie1);
        movieManager.addMovie(movie2);
        
        System.out.println();
        System.out.println("=== 등록된 영화 목록 ===");
        // TODO: MovieManager를 통해 모든 영화를 조회하고 출력하세요.
        List<Movie> movies = movieManager.findAllMovies();
        for (int i = 0; i < movies.size(); i++) {
        	System.out.println(movies.get(i));
        }

        System.out.println();
        System.out.println("=== GlobalMovieService 직접 테스트 ===");
        // TODO: GlobalMovieService를 직접 가져와서 테스트하세요.
        // - context.getBean()을 사용하여 빈 이름으로 가져옵니다.
        MovieService gms = ctx.getBean("globalMovieService", MovieService.class);
        
        Movie movie3 = new Movie(3, "꿈의 설계자", "알렉스 싸피", "SF", 148);
        gms.registerMovie(movie3);
        
        // TODO: 컨테이너를 종료하세요.
        ctx.close();
    }
}
