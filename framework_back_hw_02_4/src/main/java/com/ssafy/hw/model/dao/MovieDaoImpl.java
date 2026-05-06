package com.ssafy.hw.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssafy.hw.model.dto.Movie;

// TODO: @Repository 어노테이션을 추가하세요.

/**
 * MovieDao 인터페이스의 HashMap 기반 구현체
 */
@Repository
public class MovieDaoImpl implements MovieDao {

    // TODO: 영화 정보를 저장할 HashMap을 선언하세요. (id를 key로 사용)
	HashMap<Integer, Movie> movies = new HashMap<>();

    @Override
    public void insert(Movie movie) {
        // TODO: HashMap에 영화 정보를 저장하세요.
    	movies.put(movie.getId(), movie);
    }

    @Override
    public Movie select(int id) {
        // TODO: HashMap에서 id로 영화를 조회하여 반환하세요.
        return movies.get(id);
    }

    @Override
    public List<Movie> selectAll() {
        // TODO: HashMap의 모든 영화를 List로 반환하세요.
        return new ArrayList<Movie>(movies.values());
    }
}
