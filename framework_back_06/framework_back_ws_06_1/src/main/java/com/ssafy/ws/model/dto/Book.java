package com.ssafy.ws.model.dto;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int price;
    private String img;    // 이미지 파일명 (예: "java-cover.jpg")

    // 기본 생성자
    public Book() {}

    // 전체 필드 생성자
    public Book(String isbn, String title, String author, int price, String img) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.img = img;
    }

    // Getter & Setter
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + ", img=" + img + "]";
    }
}
