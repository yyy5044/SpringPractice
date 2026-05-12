package com.ssafy.hw.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.hw.dto.Movie;

@Service
public class MovieService {

    private final Map<Integer, Movie> movieStore = new HashMap<>();
    private int sequence = 0;

    public MovieService() {
        save(new Movie(0, "꿈의 설계자", "알렉스 싸피", "SF", 148, LocalDate.of(2010, 7, 21)));
        save(new Movie(0, "공생의 법칙", "장싸피", "드라마", 132, LocalDate.of(2019, 5, 30)));
        save(new Movie(0, "푸른 행성2", "데이빗 싸피", "SF", 192, LocalDate.of(2022, 12, 14)));
    }

    public Movie save(Movie movie) {
        movie.setId(++sequence);
        movieStore.put(movie.getId(), movie);
        return movie;
    }

    public List<Movie> findAll() {
        return new ArrayList<>(movieStore.values());
    }
}
