package com.epam.mentoring;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderFromJar {
	public static final String BASE_PATH = System.getProperty("user.dir")
			+ "/jars/";
	public static final String PACKAGE_FOR_RELOADED_CLASSES = "com.epam.mentoring.sample.";

	@SuppressWarnings("rawtypes")
	public Class reloadClassFromJar(String jarName, String className)
			throws Exception {
		String pathForJar = BASE_PATH + jarName;
		try (URLClassLoader loader = new URLClassLoader(new URL[] { new URL(
				new File(pathForJar).toURI().toURL().toString()) })) {
			return Class.forName(PACKAGE_FOR_RELOADED_CLASSES + className,
					true, loader);

		}
	}

}
