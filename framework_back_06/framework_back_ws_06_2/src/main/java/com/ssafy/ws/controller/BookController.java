package com.ssafy.ws.controller;

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

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;

/**
 * 6-2. 파일 업로드: MultipartFile
 *
 * 실습 목표:
 * - MultipartFile을 사용한 파일 업로드 구현
 * - 도서 등록 시 이미지 파일 함께 저장
 *
 * MultipartFile 주요 메서드:
 * - isEmpty(): 파일 존재 여부
 * - getOriginalFilename(): 원본 파일명
 * - getSize(): 파일 크기
 * - getContentType(): MIME 타입
 * - transferTo(File): 파일 저장
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Value("${file.upload.path}")
    private String uploadPath;

    /**
     * 도서 목록 조회
     */
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookService.selectAll());
        return "book/list";
    }

    /**
     * 도서 등록 폼
     */
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/addForm";
    }

    /**
     * 도서 등록 처리 (파일 업로드 포함)
     *
     * @param book 도서 정보
     * @param file 업로드할 이미지 파일
     */
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book,
                          @RequestParam("file") MultipartFile file) 
    					  throws IOException {
        // TODO: 파일 업로드 처리를 구현하세요
        // 1. 파일이 존재하는지 확인
        // 2. 업로드 디렉토리 생성
        // 3. 고유 파일명을 생성하여 파일 저장
        // 4. 저장된 파일명을 book 객체에 설정
    	if (file != null && !file.isEmpty()) {
    		String originalName = file.getOriginalFilename();
    		String savedName = UUID.randomUUID() + "_" + originalName;
    		
    		File uploadDir = new File(uploadPath);
    		if (!uploadDir.exists()) {
    			uploadDir.mkdirs();
    		}
    		
    		File dest = new File(uploadPath + savedName);
    		file.transferTo(dest);
    		
    		book.setImg(savedName);
    	}
    	
        // 도서 등록
        bookService.insert(book);
        return "redirect:/book/list";
    }
}
