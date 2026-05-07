package com.ssafy.ws.model.dto;

public class Review {
    private int reviewNo;
    private String isbn;
    private String content;
    private int score;

    public Review() {}

    public Review(String isbn, String content, int score) {
        this.isbn = isbn;
        this.content = content;
        this.score = score;
    }

    public Review(int reviewNo, String isbn, String content, int score) {
        this.reviewNo = reviewNo;
        this.isbn = isbn;
        this.content = content;
        this.score = score;
    }

    public int getReviewNo() { return reviewNo; }
    public void setReviewNo(int reviewNo) { this.reviewNo = reviewNo; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public String toString() {
        return "Review [reviewNo=" + reviewNo + ", isbn=" + isbn + ", content=" + content + ", score=" + score + "]";
    }
}
