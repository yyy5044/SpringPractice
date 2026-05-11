package com.ssafy.ws.aspect;

// TODO: 필요한 import문 추가
 import org.aspectj.lang.ProceedingJoinPoint;
 import org.aspectj.lang.annotation.Around;
 import org.aspectj.lang.annotation.Aspect;
 import org.springframework.stereotype.Component;
 import org.springframework.util.StopWatch;

/**
 * 서비스 메서드 실행 시간을 측정하는 Aspect
 *
 * TODO 1: @Aspect 어노테이션 추가
 * TODO 2: @Component 어노테이션 추가
 */
@Aspect
@Component
public class PerformanceAspect {

    /**
     * 서비스 메서드의 실행 시간을 측정하는 Around 어드바이스
     *
     * TODO 3: @Around 어노테이션 추가 (service 패키지 대상)
     * TODO 4: ProceedingJoinPoint 파라미터 추가
     * TODO 5: StopWatch를 사용하여 실행 시간 측정
     * TODO 6: 실행 시간 출력
     *         - 형식: [Performance] 클래스명.메서드명 - 실행 시간: Xms
     * TODO 7: 대상 메서드의 반환값을 return
     */
	@Around("execution(* com.ssafy.ws.service.*.*(..))")
    public Object measureTime(ProceedingJoinPoint pjp) throws Throwable {
        // TODO: 구현하시오
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object result = pjp.proceed();
		stopWatch.stop();
		
		System.out.println("[Performance] " + pjp.getTarget().getClass().getSimpleName() +
			"." + pjp.getSignature().getName() +
			" - 실행 시간: " + stopWatch.getTotalTimeMillis() + "ms");
		
        return result;
    }
}
