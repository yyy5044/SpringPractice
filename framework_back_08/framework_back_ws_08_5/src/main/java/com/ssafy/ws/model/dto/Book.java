package com.ssafy.ws.model.dto;

/**
 * Book DTO 클래스
 *
 * DB 컬럼명과 Java 필드명이 다른 경우:
 * - DB: running_time (snake_case)
 * - Java: runningTime (camelCase)
 *
 * 해결 방법:
 * 1. ResultMap 사용
 * 2. map-underscore-to-camel-case=true 설정
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int price;
    private int runningTime;  // DB: running_time

    public Book() {
    }

    public Book(String isbn, String title, String author, int price, int runningTime) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.runningTime = runningTime;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + ", runningTime="
                + runningTime + "]";
    }
}
