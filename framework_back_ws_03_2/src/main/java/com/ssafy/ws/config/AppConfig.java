package com.ssafy.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: 필요한 어노테이션을 import 하세요.

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.service.BookService;

/**
 * 애플리케이션 설정 클래스
 * XML 설정을 Java Config로 변환
 *
 * 기존 XML 설정:
 * <beans>
 *     <bean id="bookDao" class="...BookDao"/>
 *     <bean id="bookService" class="...BookService">
 *         <constructor-arg ref="bookDao"/>
 *     </bean>
 * </beans>
 *
 * TODO: @Configuration 어노테이션을 추가하세요.
 */
// TODO: 적절한 어노테이션을 추가하세요.
@Configuration
public class AppConfig {

    /**
     * BookDao Bean 등록
     *
     * TODO: @Bean 어노테이션을 추가하세요.
     */
    // TODO: 적절한 어노테이션을 추가하세요.
	@Bean
    public BookDao bookDao() {
        // TODO: BookDao 인스턴스를 생성하여 반환하세요.
        return new BookDao();
    }

    /**
     * BookService Bean 등록
     *
     * TODO: @Bean 어노테이션을 추가하세요.
     */
    // TODO: 적절한 어노테이션을 추가하세요.
	@Bean
    public BookService bookService() {
        // TODO: BookService 인스턴스를 생성하여 반환하세요.
        // 힌트: 의존성 주입을 위해 다른 @Bean 메서드를 활용하세요.
        return new BookService(bookDao());
    }
}
