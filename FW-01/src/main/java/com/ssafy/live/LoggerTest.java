package com.ssafy.live;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

	private static final Logger log = LoggerFactory.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		log.trace("trace level: {} {}", 1, true);
		log.debug("debug level: {} {}", 1, true);
		log.info("info level: {} {}", 1, true);
		log.warn("warn level: {} {}", 1, true);
		log.error("error level: {} {}", 1, true);
	}

}
