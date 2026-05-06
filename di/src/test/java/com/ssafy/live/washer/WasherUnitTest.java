package com.ssafy.live.washer;

import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.live.washer.SWasher;
import com.ssafy.live.washer.Washer;
import com.ssafy.live.washer.WasherConfig;
import com.ssafy.live.washer.WasherUser;

public class WasherUnitTest {
	ApplicationContext ctx;
	
	@BeforeEach
	void setup() {
		ctx = new AnnotationConfigApplicationContext(WasherConfig.class);
	}
	
	
	@Test
	void beanTest() {
		//given
		SWasher swasher = ctx.getBean(SWasher.class);
		WasherUser user = ctx.getBean(WasherUser.class);
		
		//when
		Washer s2 = user.getWasher();
		
		//then
		Assertions.assertSame(s2, swasher);
	}
	
}
