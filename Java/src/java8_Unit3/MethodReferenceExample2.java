package java8_Unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java8_Unit1.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("abc", "kohli", 30), new Person("cef", "czoni", 40),
				new Person("ghi", "yuvi", 50), new Person("cef", "dhoni", 40), new Person("ghi", "cuvi", 50));
		printConditionally(people, p -> p.getFirstName().startsWith("c"), System.out::println);
	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person p : people) {
			if (predicate.test(p))
				consumer.accept(p);
		}
	}

}
