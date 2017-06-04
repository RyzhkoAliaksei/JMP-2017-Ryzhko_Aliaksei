package com.epam.mentoring.eightFeature.function;

@FunctionalInterface
public interface ThreeFunction<T, U, S, R> {

	default void checkAdult(int age) {
		if (moreThenEighteen(age))
			System.out.println("Person more then 18");
	}

	default void calculateAverage(int x, int y) {
		System.out.println("Average age- "+(x + y) / 2);
	}

	static boolean moreThenEighteen(int age) {
		System.out.println("Interface more then 18 check");

		return age >= 18;
	}

	R apply(T t, U u, S s);
}
