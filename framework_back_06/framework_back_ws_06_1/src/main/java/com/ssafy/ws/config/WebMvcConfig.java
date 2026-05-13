package com.ssafy.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { // 등록부(registry)를 받아서
        // TODO: 외부 폴더 이미지를 URL로 접근 가능하게 설정
        // /images/abc.jpg -> C:/uploads/book/abc.jpg
        // Hint: addResourceHandler()와 addResourceLocations() 메서드를 사용
        // Hint: 파일 시스템 경로는 "file:///" 접두사를 붙여서 지정
    	
    	// 등록부 작성
    	registry.addResourceHandler("/images/**")
    			.addResourceLocations("file:///" + uploadPath + "/");
    	// file://은 로컬 파일 시스템에 접근하기 위한 프로토콜
    	// **은 하위 경로 전부, *은 한 단계 아래만
    	
    }
}
