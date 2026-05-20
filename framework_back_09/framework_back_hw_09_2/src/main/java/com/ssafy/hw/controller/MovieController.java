package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.hw.model.dto.Movie;
import com.ssafy.hw.service.MovieService;

/**
 * 영화 컨트롤러 (JSP)
 * 동적 SQL 기반 검색 폼을 제공하는 컨트롤러
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 영화 검색 페이지 (if + choose 태그 활용)
     * GET /movie/search
     */
    @GetMapping("/search")
    public String search(
            @RequestParam(required = false, defaultValue = "all") String searchType,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "title") String orderBy,
            @RequestParam(required = false, defaultValue = "asc") String orderDir,
            Model model) {

        List<Movie> movies;
        if (keyword != null && !keyword.isEmpty()) {
            movies = movieService.searchByType(searchType, keyword);
        } else {
            movies = movieService.searchWithSort(keyword, orderBy, orderDir);
        }

        model.addAttribute("movies", movies);
        model.addAttribute("searchType", searchType);
        model.addAttribute("keyword", keyword);
        model.addAttribute("orderBy", orderBy);
        model.addAttribute("orderDir", orderDir);

        return "movie/search";
    }
}
