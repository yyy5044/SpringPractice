package com.ssafy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.ws.model.dto.Book;

// TODO: @Component 어노테이션 적용
@Component
public class BookShelf {
    // TODO: List<Book> 필드 선언
	List<Book> books = new ArrayList<>();
	
    // TODO: 생성자 작성
    // 생성자에서 초기 책 2권 추가:
    // - "Good Code", "James Ssafy"
    // - "Practical Java", "박싸피"
	public BookShelf() {
		books.add(new Book("Good Code", "James Ssafy"));
		books.add(new Book("Practical Java", "박싸피"));
	}
	
    // TODO: addBook() 메서드 작성
	public void addBook(String title, String author) {
		books.add(new Book(title, author));
	}
	
    // TODO: getBooks() 메서드 작성
	public Book getBooks(int idx) {
		return books.get(idx);
	}
}
