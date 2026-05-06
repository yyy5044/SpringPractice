package com.ssafy.live.washer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WasherUserTest {
	
	public static void main(String[] args) {
		// 스프링 동작 시키기
		ApplicationContext ctx = new AnnotationConfigApplicationContext(WasherConfig.class);
		
		// 빈 요청
		SWasher swasher = ctx.getBean(SWasher.class);
		WasherUser user = ctx.getBean(WasherUser.class);
		
		// 기본은 타입으로 관리, 필요시 이름 개입!
		ctx.getBean("lWasher", Washer.class);
		
		// NoUnique 에러
		//ctx.getBean(Washer.class);
		
		user.useWasher("바지");
		Washer s2 = user.getWasher();
		
		System.out.println(swasher == s2);
	}
}
