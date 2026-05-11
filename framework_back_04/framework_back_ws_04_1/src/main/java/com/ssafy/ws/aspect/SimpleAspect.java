package com.ssafy.ws.aspect;

// TODO: 필요한 import문 추가
 import org.aspectj.lang.annotation.Aspect;
 import org.aspectj.lang.annotation.Before;
 import org.springframework.stereotype.Component;

/**
 * 간단한 Aspect 클래스
 * AOP 의존성이 정상적으로 추가되었는지 확인하기 위한 클래스
 *
 * TODO 1: @Aspect 어노테이션 추가
 * TODO 2: @Component 어노테이션 추가
 */
@Component
@Aspect
public class SimpleAspect {

    /**
     * 간단한 Before 어드바이스
     *
     * TODO 3: @Before 어노테이션 추가
     *         - Pointcut: execution(* com.ssafy.ws.AopConfigChecker.*(..))
     *
     * TODO 4: 메서드 실행 전 메시지 출력
     *         - "SimpleAspect: 메서드 실행 전"
     */
	@Before("execution(* com.ssafy.ws.AopConfigChecker.*(..))")
    public void beforeAdvice() {
        // TODO: 구현하시오
    	System.out.println("SimpleAspect: 메서드 실행 전");
    }
}
