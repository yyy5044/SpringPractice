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
        insert(new Book("978-89-04", "JPA 활용", "박싸피", 38000));
    }

    /**
     * 도서 등록
     */
    public int insert(Book book) {
        // TODO: 중복 isbn 체크 후 도서를 저장소에 추가
        // 이미 존재하면 0 반환, 등록 성공 시 1 반환
    	
    	String isbn = book.getIsbn();
    	if (bookStore.containsKey(isbn)) return 0;
    	
    	bookStore.put(isbn, book);
    	
        return 1;
    }

    /**
     * 전체 도서 조회
     */
    public List<Book> selectAll() {
        // TODO: 저장소의 모든 도서를 리스트로 반환
        return new ArrayList<Book>(bookStore.values());
    }
}
