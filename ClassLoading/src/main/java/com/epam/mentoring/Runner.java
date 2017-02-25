package com.epam.mentoring;

import org.apache.log4j.Logger;

public class Runner {

	private final static Logger logger = Logger.getLogger(Runner.class);

	public static void main(String[] args) throws Exception {
		logger.info("Start programm");
		TravelResolver travelResolver = new TravelResolver();
		TravelType travelType = travelResolver.runTravel();
		if (travelType != null) {
			logger.info(travelType.goToTravel());
		}
	}
}