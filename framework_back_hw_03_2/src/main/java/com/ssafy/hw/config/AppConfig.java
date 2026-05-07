package com.ssafy.hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.hw.model.dao.MovieDao;
import com.ssafy.hw.service.MovieService;

// TODO: @Configuration 어노테이션 적용
@Configuration
public class AppConfig {

    // TODO: @Bean 어노테이션을 사용하여 MovieDao 빈 등록
    // 메서드명: movieDao
	@Bean
	public MovieDao movieDao() {
		return new MovieDao();
	}

    // TODO: @Bean 어노테이션을 사용하여 MovieService 빈 등록
    // 메서드명: movieService
    // MovieDao를 생성자로 주입
	@Bean
	public MovieService movieService() {
		return new MovieService(movieDao());
	}
}
