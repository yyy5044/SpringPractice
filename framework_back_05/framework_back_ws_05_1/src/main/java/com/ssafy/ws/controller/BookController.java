package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;

// TODO: 이 클래스를 컨트롤러로 등록하고 적절한 URL 매핑을 설정하세요.
@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 도서 목록 조회
     */
    // TODO: 적절한 HTTP 메서드 매핑을 추가하세요.
    @GetMapping("/list")
    public String list(Model model) {
        // TODO: 전체 도서 목록을 조회하여 뷰에 전달하고, 목록 페이지를 반환
    	List<Book> books = bookService.selectAll();
    	model.addAttribute("books", books);
        return "book/list";
    }
}
