package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * AOP 설정을 확인하는 클래스
 */
@Component
public class AopConfigChecker {

    /**
     * AOP 설정을 확인하고 결과를 출력한다
     *
     * TODO 1: ApplicationContext에서 모든 Bean 이름을 가져온다
     *         - context.getBeanDefinitionNames()
     *
     * TODO 2: AOP 관련 Bean을 찾아 출력한다
     *         - Bean 이름에 "aop" 또는 "Aspect"가 포함된 것을 찾는다
     *         - 대소문자 구분 없이 검색 (toLowerCase() 사용)
     *
     * TODO 3: AOP 자동 설정 확인 메시지 출력
     *         - "AOP 자동 설정이 활성화되어 있습니다."
     */
    public void checkAopConfig(ApplicationContext context) {
        System.out.println("=== AOP 설정 확인 ===");
        // TODO: 구현하시오
        String[] names = context.getBeanDefinitionNames();
        int count = 0;
        for (int i = 0; i < names.length; i++) {
        	if (names[i].toLowerCase().contains("aop") || names[i].toLowerCase().contains("aspect")) {
        		count++;
        		System.out.println(count+"개: "+names[i]);
        		
        	}
        }
        
        System.out.println("AOP 자동 설정이 활성화되어 있습니다.");
    }
}
