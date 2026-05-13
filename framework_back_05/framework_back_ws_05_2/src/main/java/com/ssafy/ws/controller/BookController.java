package com.ssafy.ws.controller;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.selectAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    // ============================================
    // [TODO] 도서 등록 폼 표시 메서드를 작성하세요.
    // ============================================
    // TODO: 등록 폼 페이지를 반환하는 메서드 구현

    // === 여기에 코드 작성 ===
    @GetMapping("/regist")
    public String addForm() {
    	return "book/regist";
    }


    // ============================================
    // [TODO] 도서 등록 처리 메서드를 작성하세요.
    // ============================================
    // TODO: 폼 데이터를 받아 도서를 등록하고 목록으로 리다이렉트 (PRG 패턴)

    // === 여기에 코드 작성 ===
    @PostMapping("/regist")
    public String add(@ModelAttribute Book book) {
    	bookService.insert(book);
    	return "redirect:/book/list";
    }

}
