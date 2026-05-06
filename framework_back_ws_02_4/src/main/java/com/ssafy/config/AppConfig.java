package com.ssafy.config;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.BookPrinter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
// TODO: 필요한 Spring 어노테이션 및 모델 클래스 import 문을 추가하세요
import org.springframework.context.annotation.Configuration;


// TODO: @Configuration 어노테이션 적용
@Configuration
public class AppConfig {

    // TODO: javaBook 빈 등록 메서드를 작성하세요
    // 값: isbn="978-89-6848-123-1", title="Java 프로그래밍", author="김싸피", price=30000
	@Bean
	public Book javaBook() {
		return new Book("978-89-6848-123-1", "Java 프로그래밍", "김싸피", 30000);
	}
	
    // TODO: springBook 빈 등록 메서드를 작성하세요
    // 값: isbn="978-89-6626-123-4", title="Spring 기초", author="박싸피", price=35000
	@Bean
	public Book springBook() {
		return new Book("978-89-6626-123-4", "Spring 기초", "박싸피", 35000);
	}
	
    // TODO: bookPrinter 빈 등록 메서드를 작성하세요
    // springBook을 주입받아 출력하도록 구현
	@Bean
	public BookPrinter bookPrinter(@Qualifier("springBook") Book book) {
		return new BookPrinter(book);
	}
	
}
