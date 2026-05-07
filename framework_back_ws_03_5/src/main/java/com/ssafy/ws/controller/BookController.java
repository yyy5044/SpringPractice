//package com.ssafy.ws.controller;
//
//// Ch03에서는 콘솔 실행(getBean) 중심이므로 Servlet 컨트롤러를 비활성화합니다.
//// 웹 UI가 필요한 경우 pom.xml의 주석을 해제하고 아래 코드를 활성화하세요.
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//
//import com.ssafy.ws.model.dto.Book;
//import com.ssafy.ws.model.dto.Review;
//import com.ssafy.ws.service.BookService;
//import com.ssafy.ws.service.ReviewService;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Controller
//public class BookController extends HttpServlet {
//
//    private final BookService bookService;
//    private final ReviewService reviewService;
//    
//    public BookController (BookService bookService, ReviewService reviewService) {
//    	this.bookService = bookService;
//    	this.reviewService = reviewService;
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        String action = preProcessing(req, resp);
//        switch (action) {
//            case "list" -> list(req, resp);
//            case "detail" -> detail(req, resp);
//            case "add-form" -> forward(req, resp, "/book/addForm.jsp");
//            case "add" -> add(req, resp);
//            case "edit-form" -> editForm(req, resp);
//            case "edit" -> edit(req, resp);
//            case "delete" -> delete(req, resp);
//            case "add-review" -> addReview(req, resp);
//            case "delete-review" -> deleteReview(req, resp);
//            default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//        }
//    }
//
//    private void list(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        try {
//            List<Book> books = bookService.getAllBooks();
//            req.setAttribute("books", books);
//            forward(req, resp, "/book/list.jsp");
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private void detail(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String isbn = req.getParameter("isbn");
//        try {
//            Book book = bookService.getBook(isbn);
//            List<Review> reviews = bookService.getReviews(isbn);
//            req.setAttribute("book", book);
//            req.setAttribute("reviews", reviews);
//            forward(req, resp, "/book/detail.jsp");
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private void add(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String isbn = req.getParameter("isbn");
//        String title = req.getParameter("title");
//        String author = req.getParameter("author");
//        int price = Integer.parseInt(req.getParameter("price"));
//        try {
//            bookService.registBook(new Book(isbn, title, author, price));
//            redirect(req, resp, "/book?action=detail&isbn=" + isbn);
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private void editForm(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String isbn = req.getParameter("isbn");
//        try {
//            Book book = bookService.getBook(isbn);
//            req.setAttribute("book", book);
//            forward(req, resp, "/book/editForm.jsp");
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private void edit(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String isbn = req.getParameter("isbn");
//        String title = req.getParameter("title");
//        String author = req.getParameter("author");
//        int price = Integer.parseInt(req.getParameter("price"));
//        try {
//            bookService.updateBook(new Book(isbn, title, author, price));
//            redirect(req, resp, "/book?action=detail&isbn=" + isbn);
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private void delete(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String isbn = req.getParameter("isbn");
//        try {
//            bookService.deleteBook(isbn);
//            redirect(req, resp, "/book?action=list");
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private void addReview(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String isbn = req.getParameter("isbn");
//        String content = req.getParameter("content");
//        int score = Integer.parseInt(req.getParameter("score"));
//        try {
//            reviewService.registReview(new Review(isbn, content, score));
//            redirect(req, resp, "/book?action=detail&isbn=" + isbn);
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private void deleteReview(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String isbn = req.getParameter("isbn");
//        int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
//        try {
//            reviewService.deleteReview(reviewNo);
//            redirect(req, resp, "/book?action=detail&isbn=" + isbn);
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private String preProcessing(HttpServletRequest req, HttpServletResponse resp) {
//        String action = req.getParameter("action");
//        if (action == null || action.isBlank()) {
//            action = "list";
//        }
//        return action;
//    }
//
//    private void redirect(HttpServletRequest request, HttpServletResponse response, String path)
//            throws IOException {
//        response.sendRedirect(request.getContextPath() + path);
//    }
//
//    private void forward(HttpServletRequest request, HttpServletResponse response, String path)
//            throws ServletException, IOException {
//        RequestDispatcher disp = request.getRequestDispatcher(path);
//        disp.forward(request, response);
//    }
//}
//
