package com.ssafy.ws.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// TODO: 이 클래스를 Aspect로 선언하세요
// TODO: 이 클래스를 Spring Bean으로 등록하세요
@Aspect
@Component
public class ResultLoggingAspect {
    // TODO: @AfterReturning 어드바이스를 구현하세요
    // - pointcut: com.ssafy.ws.service 패키지의 모든 메서드
    // - returning: 반환값을 "result"라는 이름으로 바인딩
	@AfterReturning(
		pointcut = "execution(* com.ssafy.ws.service.*.*(..))",
		returning = "result"
	)
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        
        // TODO: 반환값에 따라 다른 로그 메시지를 출력하세요
        // 1. result가 null인 경우: "[메서드명] 완료 - 반환값: null (조회 결과 없음)"
        // 2. result가 List인 경우: "[메서드명] 완료 - 반환된 목록 개수: N"
        // 3. 그 외의 경우: "[메서드명] 완료 - 반환값: {result}"
        if (result == null) {
        	System.out.println("["+methodName+"]" + " 완료 - " + "반환값: null (조회 결과 없음)");
        } else if (result instanceof List) {
        	List<Object> list = (List) result;
        	System.out.println("["+methodName+"]" + " 완료 - "+"반환된 목록 개수: " + list.size());
        } else {
        	System.out.println("["+methodName+"]" + " 완료 - "+"반환값: {" + result+"}");
        }

    }
}
