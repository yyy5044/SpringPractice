package com.ssafy.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 8-5: 설정 실습
 *
 * 학습 목표:
 * 1. TypeAlias를 설정하여 XML을 간결하게 작성
 * 2. ResultMap을 정의하여 컬럼-필드 매핑
 * 3. SQL 로깅 설정
 */
@SpringBootApplication
public class FrameworkBackWs085Application {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkBackWs085Application.class, args);
    }
}
