package com.ssafy.ws.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// TODO: 이 클래스를 Aspect로 동작하게 하는 어노테이션을 추가하세요
// TODO: Spring Bean으로 등록하는 어노테이션을 추가하세요
@Aspect
@Component
public class ExceptionLoggingAspect {
    // TODO: @AfterThrowing 어드바이스를 구현하세요
    // - pointcut: com.ssafy.ws.service 패키지의 모든 메서드
    // - throwing: 예외 객체를 바인딩할 파라미터 이름
    // 요구사항:
    // 1. 예외가 IllegalArgumentException이면 WARN 레벨로 로깅
    // 2. 그 외 예외는 ERROR 레벨로 로깅
    // 3. 메서드명과 인자 정보를 포함
	@AfterThrowing(
		pointcut = "execution(* com.ssafy.ws.service.*.*(..))",
		throwing = "ex"
	)
    public void logException(JoinPoint joinPoint, Exception ex) {
        // TODO: 메서드 이름 가져오기
    	String methodName = joinPoint.getSignature().getName();
    	
        // TODO: 인자 정보 가져오기
    	String params = Arrays.toString(joinPoint.getArgs());

        // TODO: 예외 타입에 따라 다른 출력 적용
        // - IllegalArgumentException: "[WARN] [메서드명] 파라미터 검증 실패: 메시지 - 인자: [인자목록]"
        // - 그 외: "[ERROR] [메서드명] 예외 발생 - 타입: 예외클래스명, 메시지: 메시지 - 인자: [인자목록]"
    	if (ex instanceof IllegalArgumentException) {
    		System.out.println("[WARN] ["+methodName+"] 파라미터 검증 실패: "+ex.getMessage()+" - " + "인자: "+params);
    	} else {
    		System.out.println("[ERROR] ["+methodName+"] 예외 발생 - 타입: "+ ex.getClass().getSimpleName() + 
    													", 메시지: " + ex.getMessage() +" - " + "인자: "+params);
    	}
    } 
}
