package com.ssafy.hw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hw.model.dao.MovieDao;
import com.ssafy.hw.model.dto.Movie;

/**
 * 영화 서비스 구현체
 */
@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> selectAll() {
        return movieDao.selectAll();
    }

    @Override
    public Movie findById(int id) {
        return movieDao.findById(id);
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieDao.searchByTitle(title);
    }

    @Override
    public List<Movie> searchByDirector(String director) {
        return movieDao.searchByDirector(director);
    }

    @Override
    public List<Movie> searchByType(String searchType, String keyword) {
        return movieDao.searchByType(searchType, keyword);
    }

    @Override
    public List<Movie> searchWithSort(String keyword, String orderBy, String orderDir) {
        return movieDao.searchWithSort(keyword, orderBy, orderDir);
    }
}
