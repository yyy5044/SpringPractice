package com.ssafy.live.washer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WasherConfig {
	
	@Bean
	public SWasher sWasher() {
		return new SWasher();
	}
	
	@Bean
	public LWasher lWasher() {
		return new LWasher();
	}
	
	@Bean("user") // value가 하나면 이렇게 별칭 가능(?)
	public WasherUser washerUser() {
		// return new WasherUser(sWasher());
		WasherUser user = new WasherUser();
		user.setWasher(sWasher());
		return user;
	}
}
