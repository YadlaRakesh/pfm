package com.appt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApptBackendApplication {

	private static Logger logger = LogManager.getLogger(ApptBackendApplication.class.getName());
	public static void main(String[] args) {
		logger.debug("This is Debug Msg");
		logger.info("This is Info Msg");
		logger.warn("This is Warn Msg");
		logger.fatal("This is fatal Msg");
		logger.error("This is Error Msg");
		SpringApplication.run(ApptBackendApplication.class, args);
	}

}
