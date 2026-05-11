package com.ssafy.hw.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.ssafy.hw.model.dto.Movie;

public class MovieDao {
    private Map<Integer, Movie> movies = new HashMap<>();

    public void save(Movie movie) {
        System.out.println("[MovieDao] 영화 저장: " + movie.getTitle());
        movies.put(movie.getId(), movie);
    }

    public Movie findById(int id) {
        return movies.get(id);
    }

    public List<Movie> findAll() {
        return new ArrayList<>(movies.values());
    }
}
