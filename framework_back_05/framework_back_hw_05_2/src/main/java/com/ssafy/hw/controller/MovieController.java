package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.hw.dto.Movie;
import com.ssafy.hw.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // ============================================
    // [미션 1] 영화 목록 조회
    // ============================================
    @GetMapping
    public String list(Model model) {
        // TODO: 영화 목록을 조회하여 뷰에 전달하고, 목록 페이지를 반환
    	List<Movie> movies = movieService.findAll();
    	
    	model.addAttribute("movies", movies);
    	
        return "movie/list";
    }

    // ============================================
    // [미션 2] 영화 등록 폼
    // ============================================
    @GetMapping("/new")
    public String addForm() {
        // TODO: 등록 폼 페이지를 반환
        return "movie/addForm";
    }

    // ============================================
    // [미션 3] 영화 등록 처리
    // - 장르가 비어 있으면 "장르 미정"으로 설정
    // - 등록 후 목록으로 리다이렉트 (PRG 패턴)
    // ============================================
    @PostMapping
    public String add(@ModelAttribute Movie movie) {
        // TODO: 장르가 null이거나 비어 있으면 "장르 미정"으로 설정
    	String genre = movie.getGenre();
    	if (genre == null || genre.equals("")) {
    		movie.setGenre("장르 미정");
    	}
    	
        // TODO: 영화를 등록하고 목록으로 리다이렉트
    	movieService.save(movie);
    	
        return "redirect:/movie";
    }
}
