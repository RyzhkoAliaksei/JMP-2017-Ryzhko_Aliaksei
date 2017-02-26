package com.epam.mentoring;

import org.apache.log4j.Logger;

public class Menu {
	private final static Logger logger = Logger.getLogger(Menu.class);
	public void getMenu() {
		logger.info("Please choose: ");
		logger.info("1 - travel by car");
		logger.info("2 - travel by plane");
		logger.info("0 - exit");
	}
}
