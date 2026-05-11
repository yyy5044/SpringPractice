package com.ssafy.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ssafy.ws.service.DataService;

@SpringBootApplication
public class FrameworkBackWs045Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FrameworkBackWs045Application.class, args);

        DataService dataService = context.getBean(DataService.class);

        System.out.println("=== 성능 측정 테스트 ===");

        // 빠른 조회 (1000ms 이하)
        dataService.quickQuery();
        System.out.println();

        // 느린 작업 (1000ms 초과)
        dataService.generateReport();
    }
}
