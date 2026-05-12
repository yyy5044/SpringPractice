package com.ssafy.hw.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Movie {

    private int id;
    private String title;
    private String director;
    private String genre;
    private int runningTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    public Movie() {
    }

    public Movie(int id, String title, String director, String genre, int runningTime, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
        this.releaseDate = releaseDate;
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    // ============================================
    // [미션 2] 상영 시간 변환 메서드
    // runningTime(분)을 "H시간 M분" 형식으로 변환하여 반환
    // 예: 148 → "2시간 28분", 60 → "1시간", 45 → "45분"
    // ============================================
    public String getRunningTimeStr() {
        // TODO: runningTime을 시간과 분으로 나누어 변환된 문자열을 반환
        int hours = runningTime / 60;
        int minutes = runningTime % 60;
        if (hours > 0 && minutes > 0) {
            return hours + "시간 " + minutes + "분";
        } else if (hours > 0) {
            return hours + "시간";
        } else {
            return minutes + "분";
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
