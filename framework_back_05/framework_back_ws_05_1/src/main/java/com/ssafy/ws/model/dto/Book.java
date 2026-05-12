package com.ssafy.ws.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 도서 정보를 담는 DTO 클래스
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    // TODO: isbn, title, author, price 필드 선언
    private String isbn;
    private String title;
    private String author;
    private int price;
	
    // TODO: 기본 생성자

    // TODO: 전체 필드 생성자

    // TODO: Getter/Setter 메서드

    // TODO: toString() 메서드
}
