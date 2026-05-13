package com.ssafy.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 외부 폴더 이미지를 URL로 접근 가능하게 설정
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///" + uploadPath);
    }

    /**
     * TODO: BeanNameViewResolver를 Bean으로 등록하세요.
     *
     * - BeanNameViewResolver는 View 이름과 동일한 Bean을 찾아 View로 사용한다.
     * - order를 0으로 설정하여 InternalResourceViewResolver보다 먼저 동작하게 한다.
     */
    @Bean
    BeanNameViewResolver beanNameViewResolver() {
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);  // 우선순위를 높게 (JSP보다 먼저 확인)
        return resolver;
    }
}
