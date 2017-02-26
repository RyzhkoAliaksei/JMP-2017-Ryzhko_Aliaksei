package com.epam.mentoring;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class TravelResolver {
	private final static Logger logger = Logger.getLogger(TravelResolver.class);
	public static final String TRAVEL_BY_CAR_JAR = "car.jar";
	public static final String TRAVEL_BY_PLANE_JAR = "plane.jar";
	public static final String TRAVEL_BY_PLANE_CLASS = "TravelByPlane";
	public static final String TRAVEL_BY_CAR_CLASS = "TravelByCar";
	Travel travel = null;
	Menu menu = new Menu();
	ClassLoaderFromJar classLoader = new ClassLoaderFromJar();

	public void runTravel() throws Exception {
		menu.getMenu();
		Scanner scanner = new Scanner(System.in);
		boolean isChoose = true;
		while (isChoose) {
			switch (scanner.nextInt()) {
			case 0: {
				logger.info("End programm");
				scanner.close();
				isChoose = false;
				System.exit(0);
				break;
			}
			case 1: {
				logger.info("Load car.jar ");
				execute(TRAVEL_BY_CAR_JAR, TRAVEL_BY_CAR_CLASS);
				break;
			}
			case 2: {
				logger.info("Load plane.jar ");
				execute(TRAVEL_BY_PLANE_JAR, TRAVEL_BY_PLANE_CLASS);
				break;
			}
			default: {
				logger.info("Try again");
			}
			}
		}
	}

	private void execute(String jarName, String className) throws Exception {
		travel = (Travel) classLoader.reloadClassFromJar(jarName, className)
				.newInstance();
		if (travel != null) {
			logger.info(travel.go());
		}
		menu.getMenu();
	}
}
