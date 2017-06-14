package com.epam.mentoring.MemoryManagement;

import java.util.Scanner;

import javassist.CannotCompileException;
import javassist.ClassPool;
///attributes -Xms15m -Xmx15m -Xmn9m  -XX:MetaspaceSize=2m -XX:MaxMetaspaceSize=4m
public class App {

	public static void main(String[] args) throws CannotCompileException {
		System.out.println("Enter type simulation: 1 - OutOfMemoryHeap 2-OutOfMemoryMetaspace 3-StackOverFlow 0-exit");
		Scanner scanner = new Scanner(System.in);
		boolean isChoose = true;
		switch (scanner.nextInt()) {
		case 0: {
			System.out.println("End programm");
			scanner.close();
			isChoose = false;
			System.exit(0);
			break;
		}
		case 1: {
			simulateOutOfMemoryHeap();
			break;
		}
		case 2: {
			simulateOutOfMemoryMetaspace();
			break;
		}
		case 3: {
			simulateStackOverflowError();
			break;
		}
		default: {
			System.out.println("Try again");
		}
		}
	}

	private static void simulateOutOfMemoryMetaspace() throws CannotCompileException {

		System.out.println("Start dynamic class creation.....\n");
		for (int i = 0; i < 2000; i++) {
			Class clazz = createClass("MyClass" + i);
			if (i % 1 == 0)
				System.out.println(clazz);
		}
	}

	private static Class createClass(String className) throws CannotCompileException {
		ClassPool pool = ClassPool.getDefault();
		return pool.makeClass(className).toClass();
	}

	private static void simulateOutOfMemoryHeap() {
		System.out.println("Start OutOfMempryError simulator...");
		String dataFromFile = CustomFileReader.readFile("src\\main\\resources\\big.txt").toString();
		System.out.println("Print data: \n" + dataFromFile);
	}

	public static void simulateStackOverflowError() {
		new FirstClass(new SecondClass());	
	}

}