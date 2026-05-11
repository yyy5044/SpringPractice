package com.ssafy.ws.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int price;

    public Book(String isbn, String title, String author, int price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        setPrice(price);
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        // TODO: 가격이 0 미만이면 IllegalArgumentException을 발생시키세요.
        // 예외 메시지: "가격은 0 이상이어야 합니다: " + price
    	if (price < 0) {
    		throw new IllegalArgumentException("가격은 0 이상이어야 합니다: " + price);
    	}
    	
        this.price = price;
    }
}
