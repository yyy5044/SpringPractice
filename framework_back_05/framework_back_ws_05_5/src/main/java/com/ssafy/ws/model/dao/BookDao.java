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
        insert(new Book("978-89-04", "실전 자바", "마이클 싸피", 36000));
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
        return bookStore.get(isbn);
    }

    /**
     * 도서 정보 수정
     */
    public int update(Book book) {
        Book existingBook = bookStore.get(book.getIsbn());
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            return 1;
        }
        return 0;
    }

    /**
     * 도서 삭제
     */
    public int delete(String isbn) {
        return bookStore.remove(isbn) != null ? 1 : 0;
    }

    // ============================================
    // [미션] 제목으로 도서를 검색하는 메서드를 구현하세요.
    // ============================================
    /**
     * 제목으로 도서 검색 (대소문자 구분 없이)
     *
     * TODO: 다음을 구현하세요.
     * 1. 결과를 담을 빈 리스트 생성
     * 2. 저장소의 전체 도서를 순회하며 제목에 keyword가 포함된 도서를 결과에 추가
     * 3. 대소문자 구분 없이 비교
     * 4. 결과 리스트 반환
     */
    public List<Book> search(String keyword) {
        List<Book> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        for (Book book : bookStore.values()) {
            if (book.getTitle().toLowerCase().contains(lowerKeyword)) {
                result.add(book);
            }
        }
        return result;
    }
}
