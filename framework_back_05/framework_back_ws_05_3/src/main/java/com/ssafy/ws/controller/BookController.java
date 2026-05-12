package com.ssafy.ws.controller;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 도서 등록 폼 표시
     */
    @GetMapping("/regist")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    /**
     * 도서 등록 처리
     */
    @PostMapping("/regist")
    public String createBook(@ModelAttribute Book book) {
        bookService.insert(book);
        return "redirect:/book/list";
    }

    // ============================================
    // [Step 1 미션] 도서 상세 조회 기능을 구현하세요.
    // ============================================
    // - @GetMapping("/{isbn}") 매핑
    // - @PathVariable String isbn으로 경로 변수 추출
    // - bookService.select(isbn)로 도서 조회
    // - Model에 "book"으로 도서 정보 추가
    // - "book/detail" 뷰 반환

    // === 여기에 코드 작성 ===
    @GetMapping("/{isbn}")
    public String detailBook(@PathVariable String isbn, Model model) {
    	model.addAttribute("book", bookService.select(isbn));
    	return "book/detail";
    }

    // ============================================
    // [Step 2 미션] 도서 수정 폼 표시 기능을 구현하세요.
    // ============================================
    // - @GetMapping("/{isbn}/edit") 매핑
    // - 기존 도서 정보를 조회하여 Model에 추가
    // - "book/edit" 뷰 반환

    // === 여기에 코드 작성 ===
    @GetMapping("/{isbn}/edit")
    public String updateBookForm(@PathVariable String isbn, Model model) {
    	model.addAttribute("book", bookService.select(isbn));
    	return "book/edit";
    }


    // ============================================
    // [Step 3 미션] 도서 수정 처리 기능을 구현하세요.
    // ============================================
    // - @PostMapping("/{isbn}") 매핑
    // - @ModelAttribute Book book으로 수정 데이터 바인딩
    // - bookService.update(book) 호출
    // - 상세 페이지로 리다이렉트 (redirect:/book/{isbn})

    // === 여기에 코드 작성 ===
    @PostMapping("/{isbn}")
    public String updateBook(@PathVariable String isbn, @ModelAttribute Book book) {
    	bookService.update(book);
    	
    	return "redirect:/book/{isbn}";
    }
    
}
