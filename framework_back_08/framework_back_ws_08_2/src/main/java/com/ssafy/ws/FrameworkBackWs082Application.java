package com.ssafy.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 8-2: 등록 실습
 *
 * 학습 목표:
 * 1. INSERT 문 작성 방법
 * 2. parameterType을 통한 객체 전달
 * 3. #{} 표현식으로 객체 필드 바인딩
 */
@SpringBootApplication
public class FrameworkBackWs082Application {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkBackWs082Application.class, args);
    }
}
