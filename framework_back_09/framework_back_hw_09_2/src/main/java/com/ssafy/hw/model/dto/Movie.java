package com.ssafy.hw.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 영화 정보 DTO
 */
public class Movie {

    private int id;
    private String title;
    private String director;
    private String genre;
    private int runningTime;        // 상영시간(분)
    private int releaseYear;    // 개봉년도
    private BigDecimal rating;      // 평점(0.0~10.0)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Movie() {}

    public Movie(int id, String title, String director, String genre,
                 int runningTime, int releaseYear, BigDecimal rating,
                 LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
