package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.selectAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/regist")
    public String showRegistForm() {
        return "book/regist";
    }

    @PostMapping("/regist")
    public String regist(Book book) {
        bookService.insert(book);
        return "redirect:/book/list";
    }
}
