package com.zmx.ssm.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogBackTest {
	
	private static Logger logger = LoggerFactory.getLogger(LogBackTest.class);
	
	public static void main(String[] args) {
		
		logger.debug("日志记录");
		logger.info(" 日志记录");
		logger.warn(" 日志记录");
	    logger.error(" 日志记录");

		
	}

}
