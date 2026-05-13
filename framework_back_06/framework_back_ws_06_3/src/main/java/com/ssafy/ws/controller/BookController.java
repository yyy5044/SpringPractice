package com.ssafy.ws.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;

/**
 * 도서 컨트롤러
 * - 도서 목록 조회와 이미지 파일 다운로드 기능을 제공한다.
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
     * TODO: 도서 이미지 파일 다운로드 메서드를 구현하세요.
     *
     * - GET /book/download/{id} 요청을 처리한다.
     * - ModelAndView를 사용하여 "fileDownloadView" View를 호출한다.
     * - model에 "downloadFile"(File 객체)과 "originalFilename"(파일명)을 담는다.
     * - 도서가 없거나 이미지가 없으면 목록으로 리다이렉트한다.
     */
    @GetMapping("/download/{id}")
    public ModelAndView download(@PathVariable long id) {
    	// 1. id로 도서 조회
    	Book book = bookService.selectById(id);
    	
    	// 2. 도서가 없거나 이미지가 없으면 목록으로 리다이렉트
        if (book == null || book.getImg() == null) {
            return new ModelAndView("redirect:/book/list");
        }
        
        // 3. 파일 객체 생성 (업로드 경로 + 파일명)
        File file = new File(uploadPath + book.getImg());
        
        ModelAndView mav = new ModelAndView("fileDownloadView");
    	mav.addObject("downloadFile", file);       // View에서 사용할 데이터
    	mav.addObject("originalFilename", book.getImg());
    	return mav;
    }
}
