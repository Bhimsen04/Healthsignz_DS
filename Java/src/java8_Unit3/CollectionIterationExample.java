package java8_Unit3;

import java.util.Arrays;
import java.util.List;

import java8_Unit1.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("ABC", "kohli", 30), new Person("CEF", "czoni", 40),
				new Person("GHI", "yuvi", 50), new Person("CEF", "dhoni", 40), new Person("GHI", "cuvi", 50));
		System.out.println("!!!!!!!! For loop !!!!!!!!");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		System.out.println("!!!!!!!! For each loop !!!!!!!!");
		for (Person p : people) {
			System.out.println(p);
		}
		System.out.println("!!!!!!!! For each method using lamda !!!!!!!!");
		people.forEach(p -> System.out.println(p));
		System.out.println("!!!!!!!! For each method using Method Reference !!!!!!!!");
		people.forEach(System.out::println);
	}
}
