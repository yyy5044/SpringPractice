package com.ssafy.ws.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 서비스 메서드 실행 시간을 측정하는 Aspect
 * - 1000ms 초과 시 WARN 레벨 로깅
 * - 1000ms 이하 시 INFO 레벨 로깅
 */
// TODO: Aspect와 Bean 등록을 위한 어노테이션 추가
@Aspect
@Component
public class PerformanceAspect {
    private static final long THRESHOLD_MS = 1000;

    /**
     * 서비스 메서드의 실행 시간을 측정하는 Around 어드바이스
     *
     * TODO: 1. Around 어드바이스 어노테이션과 Pointcut 표현식 작성
     *       (com.ssafy.ws.service 패키지의 모든 메서드에 적용)
     */
    @Around("execution(* com.ssafy.ws.service.*.*(..))")
    public Object measureTime(ProceedingJoinPoint pjp) throws Throwable {
        // TODO: 2. StopWatch 객체 생성
    	StopWatch stopWatch = new StopWatch();
    	
        try {
            // TODO: 3. StopWatch 시작 및 대상 메서드 실행
        	stopWatch.start();
            Object result = pjp.proceed();
            
            return result;
        } finally {
            // TODO: 4. StopWatch 중지 및 실행 시간 측정
        	stopWatch.stop();
        	
            long executionTime = stopWatch.getTotalTimeMillis();
            String methodName = pjp.getSignature().getName();

            // TODO: 5. 임계값(THRESHOLD_MS) 기준으로 WARN 또는 INFO 레벨 로깅
            if (executionTime > THRESHOLD_MS) {
            	System.out.println("[WARN] [" + methodName + "] 실행 시간: " +
            	        executionTime + "ms (임계값 초과!)");
            } else {
            	System.out.println("[" + methodName + "] 실행 시간: " + executionTime + "ms");
            }
        }
    }
}
