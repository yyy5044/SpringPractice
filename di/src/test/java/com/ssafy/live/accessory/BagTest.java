package com.ssafy.live.accessory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BagConfig.class)
public class BagTest {
	
	@Autowired
	Bag bag;
	
	@Test
	void beanTest() {
		Assertions.assertNotNull(bag);
	}
}
