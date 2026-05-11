package com.ssafy.ws;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.Review;
import com.ssafy.ws.service.BasicBookService;
import com.ssafy.ws.service.BasicReviewService;
import com.ssafy.ws.service.BookService;
import com.ssafy.ws.service.ReviewService;

@SpringBootApplication
public class FrameworkBackWs035Application {

	public static void main(String[] args) throws Exception {
		// TODO: SpringApplication.run()의 반환값 ApplicationContext에서
		// getBean()으로 BookService, ReviewService를 꺼내 CRUD 동작을 확인하세요.
		ApplicationContext ctx = SpringApplication.run(FrameworkBackWs035Application.class, args);
		ReviewService reviewService = ctx.getBean(BasicReviewService.class);
        BookService bookService = ctx.getBean(BasicBookService.class);
        
        System.out.println("========================================");
        System.out.println("  도서 관리 시스템 (Servlet 기반)");
        System.out.println("========================================");

        // 도서 등록
        System.out.println("=== 도서 등록 ===");
        bookService.registBook(new Book("978-89-1", "Java 프로그래밍", "김싸피", 30000));
        System.out.println("등록: " + bookService.getBook("978-89-1"));
        bookService.registBook(new Book("978-89-2", "스프링 기초", "박싸피", 25000));
        System.out.println("등록: " + bookService.getBook("978-89-2"));

        // 리뷰 등록
        System.out.println("\n=== 리뷰 등록 ===");
        reviewService.registReview(new Review("978-89-1", "입문서로 최고!", 5));
        reviewService.registReview(new Review("978-89-1", "설명이 친절해요", 4));
        List<Review> reviews = bookService.getReviews("978-89-1");
        for (Review r : reviews) {
            System.out.println("등록: " + r);
        }

        // 도서 상세 조회 (리뷰 포함)
        System.out.println("\n=== 도서 상세 조회 (리뷰 포함) ===");
        Book book = bookService.getBook("978-89-1");
        System.out.printf("도서: %s (%s) - %,d원%n", book.getTitle(), book.getAuthor(), book.getPrice());
        for (Review r : bookService.getReviews("978-89-1")) {
            System.out.printf("  리뷰 %d: %s (★%d)%n", r.getReviewNo(), r.getContent(), r.getScore());
        }

        // 전체 도서 목록
        System.out.println("\n=== 전체 도서 목록 ===");
        for (Book b : bookService.getAllBooks()) {
            System.out.println("- " + b.getTitle() + " (" + b.getAuthor() + ")");
        }

        // 도서 삭제 (리뷰 연쇄 삭제)
        System.out.println("\n=== 도서 삭제 (리뷰 연쇄 삭제) ===");
        bookService.deleteBook("978-89-1");
        System.out.println("도서 삭제: 978-89-1 (관련 리뷰 삭제 완료)");
        System.out.println("남은 도서: " + bookService.getAllBooks().size() + "건");

        System.out.println("========================================");
	}
}
