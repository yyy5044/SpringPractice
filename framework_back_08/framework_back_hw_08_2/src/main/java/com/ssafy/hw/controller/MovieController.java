package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.hw.model.dto.Movie;
import com.ssafy.hw.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Movie> movies = movieService.selectAll();
        model.addAttribute("movies", movies);
        return "movie/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Movie movie = movieService.selectById(id);
        model.addAttribute("movie", movie);
        return "movie/detail";
    }

    @GetMapping("/regist")
    public String registForm() {
        return "movie/regist";
    }

    @PostMapping("/regist")
    public String regist(Movie movie) {
        movieService.insert(movie);
        return "redirect:/movie/list";
    }

}
