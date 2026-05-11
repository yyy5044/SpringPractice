package com.ssafy.hw.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// TODO: 이 클래스를 Aspect로 만들기 위한 어노테이션을 추가하시오.
// TODO: 이 클래스를 Spring Bean으로 등록하기 위한 어노테이션을 추가하시오.
@Aspect
@Component
@Slf4j
public class MovieLoggingAspect {
    // TODO: @Before 어드바이스를 작성하시오.
    // - MovieService의 모든 메서드 실행 전에 호출되도록 Pointcut 표현식 작성
    // - 메서드명과 파라미터 정보를 로그로 출력
    // - 출력 형식: "[메서드명] 호출 - 파라미터: [파라미터들]"
	@Before("execution(* com.ssafy.hw.service.MovieService.*(..))")
    public void logBeforeMethod(JoinPoint jp) {
        // TODO: 메서드명 추출
		String methodName = jp.getSignature().getName();
        // TODO: 파라미터 추출
		String params = Arrays.toString(jp.getArgs());
        // TODO: 로그 출력
		log.info("[{}] 호출 - 파라미터: {}", methodName, params);
    }
}
