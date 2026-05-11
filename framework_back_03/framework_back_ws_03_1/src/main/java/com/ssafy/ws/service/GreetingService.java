package com.ssafy.ws.service;

import org.springframework.stereotype.Service;

// TODO: 필요한 import 문을 추가하세요.

/**
 * 인사 서비스 클래스
 *
 * TODO: @Service 어노테이션을 추가하세요.
 */
// TODO: 적절한 어노테이션을 추가하세요.
@Service
public class GreetingService {

    /**
     * 이름을 받아 인사 메시지를 반환합니다.
     * @param name 인사할 대상 이름
     * @return 인사 메시지
     */
    public String greet(String name) {
        // TODO: "Hello, " + name + "!" 형식의 인사 메시지를 반환하세요.
        return "Hello, " + name + "!";
    }
}
