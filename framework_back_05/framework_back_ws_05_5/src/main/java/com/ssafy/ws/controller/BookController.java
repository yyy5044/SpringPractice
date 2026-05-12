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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // ============================================
    // [미션] 검색 기능을 포함한 도서 목록 조회를 구현하세요.
    // ============================================
    /**
     * 도서 목록 조회 (검색 기능 포함)
     *
     * TODO: 다음을 구현하세요.
     * 1. @RequestParam(required = false)로 keyword 파라미터 받기
     * 2. keyword가 있으면 bookService.search(keyword) 호출
     * 3. keyword가 없으면 bookService.selectAll() 호출
     * 4. 검색어가 있으면 model에 "keyword"도 추가 (폼에서 검색어 유지용)
     * 5. model에 "books" 추가
     * 6. "book/list" 반환
     */
    @GetMapping("/list")
    public String list(@RequestParam(required = false) String keyword, Model model) {
        // === 여기에 코드 작성 ===
        // 힌트: @RequestParam(required = false) String keyword 파라미터 추가
    	if (keyword == null) {
    		List<Book> books = bookService.selectAll();
            model.addAttribute("books", books);
    	} else {
    		List<Book> books = bookService.search(keyword);
    		model.addAttribute("books", books);
    	}

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

    /**
     * 도서 상세 조회
     */
    @GetMapping("/{isbn}")
    public String detail(@PathVariable String isbn, Model model) {
        Book book = bookService.select(isbn);
        model.addAttribute("book", book);
        return "book/detail";
    }

    /**
     * 도서 수정 폼 표시
     */
    @GetMapping("/{isbn}/edit")
    public String editForm(@PathVariable String isbn, Model model) {
        Book book = bookService.select(isbn);
        model.addAttribute("book", book);
        return "book/edit";
    }

    /**
     * 도서 수정 처리
     */
    @PostMapping("/{isbn}")
    public String update(@PathVariable String isbn, @ModelAttribute Book book) {
        bookService.update(book);
        return "redirect:/book/" + isbn;
    }

    /**
     * 도서 삭제 처리
     */
    @PostMapping("/{isbn}/delete")
    public String delete(@PathVariable String isbn) {
        bookService.delete(isbn);
        return "redirect:/book/list";
    }
}
