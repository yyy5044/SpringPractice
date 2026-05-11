package com.ssafy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.config.AppConfig;
import com.ssafy.service.BookManager;

public class MainApp {
    public static void main(String[] args) {
        // TODO: AnnotationConfigApplicationContext 생성 (AppConfig.class 사용)
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	
        // TODO: BookManager Bean 조회
    	BookManager bm = ctx.getBean(BookManager.class);
    	
        // TODO: printAllBooks() 메서드 호출
    	bm.printAllBooks();
    }
}
