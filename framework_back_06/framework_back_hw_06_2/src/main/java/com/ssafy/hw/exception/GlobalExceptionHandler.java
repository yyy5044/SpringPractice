package com.ssafy.hw.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 6-2 과제: 전역 예외 처리기
 *
 * TODO: @ControllerAdvice와 @ExceptionHandler를 사용하여
 *       InvalidFilenameException을 처리하는 메서드를 구현하세요.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // TODO: InvalidFilenameException 예외 처리 메서드 구현
    //       - 예외 메시지를 model에 담아 에러 전용 뷰로 포워딩
	@ExceptionHandler(InvalidFilenameException.class)
	public String handleInvalidFilename(InvalidFilenameException ex, Model model) {
		model.addAttribute("error", ex.getMessage());
		return "error/invalidFilename";
	}
	
	
    // TODO: 일반 Exception 예외 처리 메서드 구현
    //       - 예외 메시지를 model에 담아 에러 전용 뷰로 포워딩
	@ExceptionHandler(Exception.class)
	public String handleInvalidFilename(Exception ex, Model model) {
		model.addAttribute("error", ex.getMessage());
		return "error/error";
	}
}
