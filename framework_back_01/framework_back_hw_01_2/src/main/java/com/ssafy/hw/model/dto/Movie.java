package com.ssafy.hw.model.dto;

import lombok.*;

// TODO: Lombok 어노테이션을 추가하세요.
// @Data, @NoArgsConstructor, @AllArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private int runningTime;
}
