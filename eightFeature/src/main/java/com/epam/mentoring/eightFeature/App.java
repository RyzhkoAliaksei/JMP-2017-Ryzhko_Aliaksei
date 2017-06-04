package com.epam.mentoring.eightFeature;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.epam.mentoring.eightFeature.function.ThreeFunction;
import com.epam.mentoring.eightFeature.model.Person;

public class App {
	public static void main(String[] args) {
		/// task 1.1
		Person person1 = new Person("Andrei", 18);
		Person person2 = new Person("Aliaksei", 23);
		Person person3 = new Person("Ivan", 16);
		Person person4 = new Person("Petr", 25);
		Person[] persons = { person1, person2, person3, person4 };
		System.out.println("Sort by name");
		Arrays.sort(persons, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
		Arrays.asList(persons).forEach(System.out::println);
		System.out.println("Sort by age");
		Arrays.sort(persons, (a, b) -> a.getAge() < b.getAge() ? -1 : a.getAge() == b.getAge() ? 0 : 1);
		Arrays.asList(persons).forEach(System.out::println);

		/// task 1.2
		Function<Person, String> sampleFunction = s -> "This person is " + s + "!!!";
		System.out.println(sampleFunction.apply(person1));
		Predicate<Integer> predicate = n -> n > 23;
		System.out.println(
				"Person " + person4.getName() + " is more then 23 years - " + predicate.test(person4.getAge()));
		Consumer<Person> consumer = i -> System.out.println("Person 2 is " + i);
		consumer.accept(person2);
		Supplier<Person> supplier = () -> new Person("Vasia", 30);
		System.out.println("New person - " + supplier.get());
		Runnable runner = () -> System.out.println("Person 2 is " + person2);
		runner.run();
		/// task 1.3 and 3
		executeTask(new ThreeFunction() {
			@Override
			public Object apply(Object x, Object y, Object z) {

				return "inner class result group of persons - " + x + " " + y + " " + z;
			}
		}, person1, person2, person3);

		executeTask((x, y, z) -> "Group of persons - " + x + " " + y + " " + z, person1, person2, person3);
		;
	}
	/// task 1.3 and 3
	public static void executeTask(ThreeFunction function, Person person1, Person person2, Person person3) {
		System.out.println(function.apply(person1, person2, person3));
		function.calculateAverage(person1.getAge(), person2.getAge());
		System.out.println("check on adult "+person1.getName());
		function.checkAdult(person1.getAge());

	}
}
