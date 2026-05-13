package com.ssafy.hw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ssafy.hw.dto.Movie;

/**
 * 영화 서비스 구현체 (메모리 기반)
 */
@Service
public class MovieServiceImpl implements MovieService {

    private Map<Long, Movie> movieStore = new HashMap<>();
    private AtomicLong idGenerator = new AtomicLong(1);

    public MovieServiceImpl() {
        Movie movie1 = new Movie(idGenerator.getAndIncrement(),
                "공생의 법칙", "장싸피", 2019, "드라마", null);
        Movie movie2 = new Movie(idGenerator.getAndIncrement(),
                "복수의 시간", "윤싸피", 2003, "스릴러", null);
        movieStore.put(movie1.getId(), movie1);
        movieStore.put(movie2.getId(), movie2);
    }

    @Override
    public List<Movie> selectAll() {
        return new ArrayList<>(movieStore.values());
    }

    @Override
    public void insert(Movie movie) {
        movie.setId(idGenerator.getAndIncrement());
        movieStore.put(movie.getId(), movie);
    }
}
