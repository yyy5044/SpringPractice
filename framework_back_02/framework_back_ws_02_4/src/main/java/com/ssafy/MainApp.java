package com.ssafy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.config.AppConfig;
import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.BookPrinter;

public class MainApp {
    public static void main(String[] args) {
        // TODO: AnnotationConfigApplicationContext 생성 (AppConfig.class 사용)
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	
        System.out.println("=== Java Config로 등록된 Bean 조회 ===");

        // TODO: "javaBook" Bean 조회 및 출력
        System.out.println(ctx.getBean("javaBook", Book.class).toString());
        
        // TODO: "springBook" Bean 조회 및 출력
        System.out.println(ctx.getBean("springBook", Book.class).toString());

        System.out.println();
        System.out.println("=== @Qualifier로 선택된 Book ===");

        // TODO: BookPrinter Bean 조회 및 printBookInfo() 호출
        ctx.getBean("bookPrinter", BookPrinter.class).printBookInfo();
    }
}
