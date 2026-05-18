package com.ssafy.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 과제 8-2: 기본 조회 및 등록
 *
 * 과제 요구사항:
 * 1. Movie DTO 클래스 확인
 * 2. MovieDao 인터페이스 작성 (@Mapper)
 * 3. MovieMapper.xml 작성 (SELECT, INSERT)
 * 4. 조회/등록 기능 구현
 */
@SpringBootApplication
public class FrameworkBackHw082Application {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkBackHw082Application.class, args);
    }
}
