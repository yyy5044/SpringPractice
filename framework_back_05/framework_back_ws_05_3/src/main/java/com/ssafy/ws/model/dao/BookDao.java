package com.ssafy.ws.model.dao;

import com.ssafy.ws.model.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDao {

    private final Map<String, Book> bookStore = new HashMap<>();

    public BookDao() {
        insert(new Book("978-89-01", "Java 프로그래밍", "김싸피", 30000));
        insert(new Book("978-89-02", "스프링 기초", "박싸피", 25000));
        insert(new Book("978-89-03", "좋은 코드", "제임스 싸피", 33000));
    }

    /**
     * 도서 등록
     */
    public int insert(Book book) {
        if (bookStore.containsKey(book.getIsbn())) {
            return 0;
        }
        bookStore.put(book.getIsbn(), book);
        return 1;
    }

    /**
     * 전체 도서 조회
     */
    public List<Book> selectAll() {
        return new ArrayList<>(bookStore.values());
    }

    /**
     * ISBN으로 도서 조회
     */
    public Book select(String isbn) {
        // TODO: isbn으로 도서를 조회하여 반환
        return bookStore.get(isbn);
    }

    /**
     * 도서 정보 수정
     */
    public int update(Book book) {
        // TODO: 도서 정보를 수정하고 결과를 반환
        // 수정 성공 시 1 반환, 대상이 없으면 0 반환
    	
    	if (book == null || !bookStore.containsKey(book.getIsbn())) return 0;
    	else {
    		bookStore.put(book.getIsbn(), book);
    		return 1;
    	}
    }
}
