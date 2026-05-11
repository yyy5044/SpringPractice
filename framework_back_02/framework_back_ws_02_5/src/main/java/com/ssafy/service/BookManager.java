package com.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO: @Component 어노테이션 적용
@Component
public class BookManager {
    // TODO: BookShelf 필드 선언
	private final BookShelf bookShelf;
	
    // TODO: @Autowired 생성자 주입 작성
	@Autowired
	public BookManager(BookShelf bookShelf) {
	    this.bookShelf = bookShelf;
	}
	
    public void printAllBooks() {
        // TODO: BookShelf의 모든 책 출력
    	for (int i = 0; i < bookShelf.books.size(); i++) {
    		System.out.println(bookShelf.books.get(i));
    	}
    }
}
