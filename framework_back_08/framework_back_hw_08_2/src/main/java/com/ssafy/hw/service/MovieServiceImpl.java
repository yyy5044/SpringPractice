package com.ssafy.hw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.hw.model.dao.MovieDao;
import com.ssafy.hw.model.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> selectAll() {
        return movieDao.selectAll();
    }

    @Override
    public Movie selectById(int id) {
        return movieDao.selectById(id);
    }

    @Override
    public int insert(Movie movie) {
        return movieDao.insert(movie);
    }
}
