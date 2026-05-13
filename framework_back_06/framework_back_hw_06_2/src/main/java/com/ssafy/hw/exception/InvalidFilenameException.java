package com.ssafy.hw.exception;

/**
 * 6-2 과제: 파일명 검증 예외
 *
 * TODO: RuntimeException을 상속받는 예외 클래스를 구현하세요.
 *
 * 과제 요구사항:
 * - 파일명이 "movie_" 접두사로 시작하지 않으면 예외 발생
 * - 기본 생성자: 접두사 규칙을 안내하는 메시지
 * - 파일명을 받는 생성자: 유효하지 않은 파일명 정보 포함
 */
public class InvalidFilenameException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // TODO: 기본 생성자 구현
    public InvalidFilenameException() {
    }
    // TODO: 파일명을 받는 생성자 구현
    public InvalidFilenameException(String msg) {
        super(msg);
    }
    
}
