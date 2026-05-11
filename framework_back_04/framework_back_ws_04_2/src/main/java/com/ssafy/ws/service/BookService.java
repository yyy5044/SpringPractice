package com.ssafy.ws.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public void registerBook(String isbn, String title, int price) {
        System.out.println("BookService.registerBook() 실행됨");
    }

    public String findBook(String isbn) {
        System.out.println("BookService.findBook() 실행됨");
        return "Book-" + isbn;
    }
}
