package com.epam.mentoring;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class TravelResolver {
	private final static Logger logger = Logger.getLogger(TravelResolver.class);
	public static final String BASE_PATH = System.getProperty("user.dir")
			+ "\\jars\\";
	public static final String PACKAGE_FOR_RELOADED_CLASSES = "com.epam.mentoring.sample.";
	public static final String TRAVEL_BY_CAR_JAR = "car.jar";
	public static final String TRAVEL_BY_PLANE_JAR = "plane.jar";
	public static final String TRAVEL_BY_PLANE_CLASS = "TravelByPlane";
	public static final String TRAVEL_BY_CAR_CLASS = "TravelByCar";

	public TravelType runTravel() throws Exception {
		getMenu();
		TravelType travelType = null;
		Scanner scanner = new Scanner(System.in);
		boolean isChoose = true;
		while (isChoose) {
			switch (scanner.nextInt()) {
			case 0: {
				logger.info("End programm");
				scanner.close();
				isChoose = false;
				break;
			}
			case 1: {
				travelType = (TravelType) reloadClassFromJar(TRAVEL_BY_CAR_JAR,
						TRAVEL_BY_CAR_CLASS).newInstance();
				logger.info("Load car.jar ");
				isChoose = false;
				break;
			}
			case 2: {
				travelType = (TravelType) reloadClassFromJar(
						TRAVEL_BY_PLANE_JAR, TRAVEL_BY_PLANE_CLASS)
						.newInstance();
				logger.info("Load plane.jar ");
				isChoose = false;
				break;
			}
			default: {
				logger.info("Try again");
			}
			}
		}
		return travelType;
	}

	private void getMenu() {
		logger.info("Please choose: ");
		logger.info("1 - travel by car");
		logger.info("2 - travel by plane");
		logger.info("0 - exit");
	}

	@SuppressWarnings("rawtypes")
	private Class reloadClassFromJar(String jarName, String className)
			throws Exception {
		String pathForJar = BASE_PATH + jarName;
		try (URLClassLoader loader = new URLClassLoader(new URL[] { new URL(
				new File(pathForJar).toURI().toURL().toString()) })) {
			return Class.forName(PACKAGE_FOR_RELOADED_CLASSES + className,
					true, loader);

		}
	}
}
