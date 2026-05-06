package com.ssafy.hw.model.dto;

/**
 * 영화 정보를 담는 DTO 클래스
 *
 * TODO: 다음 필드를 선언하세요.
 * - id (int): 영화 ID
 * - title (String): 영화 제목
 * - director (String): 감독
 * - genre (String): 장르
 * - runningTime (int): 상영 시간(분)
 */
public class Movie {
    // TODO: 필드를 선언하세요.
	int id;
	String title;
	String director;
	String genre;
	int runningTime;
	
    // TODO: 기본 생성자를 작성하세요.
	public Movie(){}
	
    // TODO: 모든 필드를 받는 생성자를 작성하세요.
	public Movie(int id, String title, String director, String genre, int runningTime) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	// TODO: 모든 필드에 대한 getter/setter를 작성하세요.
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

    // TODO: toString() 메서드를 오버라이드하세요.
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre + ", runningTime="
				+ runningTime + "]";
	}
	
}
