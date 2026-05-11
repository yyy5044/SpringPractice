package com.ssafy.ws.aspect;

// TODO: 필요한 import문 추가
 import java.util.Arrays;
 import org.aspectj.lang.JoinPoint;
 import org.aspectj.lang.annotation.Aspect;
 import org.aspectj.lang.annotation.Before;
 import org.springframework.stereotype.Component;

/**
 * 서비스 메서드 호출 시 로깅하는 Aspect
 *
 * TODO 1: @Aspect 어노테이션 추가
 * TODO 2: @Component 어노테이션 추가
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * 서비스 메서드 호출 전 로깅하는 Before 어드바이스
     *
     * TODO 4: @Before 어노테이션 추가 (service 패키지 대상)
     * TODO 5: JoinPoint 파라미터 추가
     * TODO 6: 메서드명과 파라미터를 획득하여 출력
     *         - 형식: [메서드명] 호출 - 파라미터: [파라미터들]
     */
	@Before("execution(* com.ssafy.ws.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // TODO: 구현하시오
		String methodName = joinPoint.getSignature().getName();
		String params = Arrays.toString(joinPoint.getArgs());
		System.out.println("[" + methodName + "] 호출 - 파라미터: " + params);
    }
}
