package com.ssafy.hw.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.hw.exception.InvalidFilenameException;
import com.ssafy.hw.dto.Movie;
import com.ssafy.hw.service.MovieService;

/**
 * 6-2 과제: 파일명 검증 ("movie_" 접두사 필수)
 *
 * 과제 요구사항:
 * - 업로드되는 파일명이 "movie_" 접두사로 시작하는지 검증
 * - 검증 실패 시 InvalidFilenameException 발생
 * - 예외 처리기에서 적절한 에러 페이지 표시
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Value("${file.upload.path}")
    private String uploadPath;

    /**
     * 영화 목록 조회
     */
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("movies", movieService.selectAll());
        return "movie/list";
    }

    /**
     * 영화 등록 폼
     */
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie/addForm";
    }

    /**
     * 영화 등록 처리 (파일명 검증 포함)
     *
     * @param movie 영화 정보
     * @param file 업로드할 이미지 파일
     */
    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie,
                           @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            // TODO: 파일명 검증 및 업로드를 구현하세요
            // 1. 원본 파일명이 "movie_" 접두사로 시작하는지 검증
            // 2. 검증 실패 시 InvalidFilenameException 발생
            // 3. 검증 성공 시 고유 파일명을 생성하여 파일 저장
            // 4. 저장된 파일명을 movie 객체에 설정
        	
        	String originalName = file.getOriginalFilename();
        	if(!originalName.startsWith("movie_")) {
        		throw new InvalidFilenameException (
        			"유효하지 않은 파일명입니다: " + originalName +
        			" (파일명은 'movie_' 접두사로 시작해야 합니다.)");
        	}

        }

        movieService.insert(movie);
        return "redirect:/movie/list";
    }
}
