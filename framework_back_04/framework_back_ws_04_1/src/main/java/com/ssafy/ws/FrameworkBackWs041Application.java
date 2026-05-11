package com.ssafy.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FrameworkBackWs041Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FrameworkBackWs041Application.class, args);

        AopConfigChecker checker = context.getBean(AopConfigChecker.class);
        checker.checkAopConfig(context);
    }
}
