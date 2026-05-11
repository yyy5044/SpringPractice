package com.ssafy.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// TODO: 필드와 getter/setter, 생성자, toString을 작성하시오.
// 필드: id, title, director, genre, runningTime

//TODO: getter/setter
@Getter 
@Setter
@NoArgsConstructor // TODO: 기본 생성자
@AllArgsConstructor // TODO: 모든 필드를 받는 생성자
@ToString // TODO: toString
public class Movie {
    // TODO: 필드 선언
	int id;
	String title;
	String director;
	String genre;
	int runningTime;
}
