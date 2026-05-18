package com.ssafy.hw.service;

import java.util.List;

import com.ssafy.hw.model.dto.Movie;

public interface MovieService {

    List<Movie> selectAll();

    Movie selectById(int id);

    int insert(Movie movie);
}
