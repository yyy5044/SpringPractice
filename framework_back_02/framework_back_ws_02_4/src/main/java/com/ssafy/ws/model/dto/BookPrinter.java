package com.ssafy.ws.model.dto;

public class BookPrinter {

    // TODO: Book 타입 필드 선언
	Book book;

    // TODO: Book을 전달받는 생성자 작성
	public BookPrinter(Book book) {
		this.book = book;
	}

    public void printBookInfo() {
        // TODO: "선택된 Book: " 접두어와 함께 Book 정보를 콘솔에 출력하세요
    	System.out.println("선택된 Book: "+book);
    }
}
