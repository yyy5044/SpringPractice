package com.ssafy.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC 설정 클래스
 * - 외부 파일 경로를 URL로 매핑
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 외부 폴더 이미지를 URL로 접근 가능하게 설정
        // /upload/abc.jpg → C:/upload/abc.jpg
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///" + uploadPath);
    }
}
