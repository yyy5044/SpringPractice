package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/detail/{isbn}")
    public String detail(@PathVariable String isbn, Model model) {
        Book book = bookService.getBook(isbn);
        model.addAttribute("book", book);
        return "detail";
    }
}
