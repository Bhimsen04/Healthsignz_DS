package java8_Unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("ABC", "kohli", 30), 
				new Person("CEF", "czoni", 40),
				new Person("GHI", "yuvi", 50), 
				new Person("CEF", "dhoni", 40), 
				new Person("GHI", "cuvi", 50));
		// Collections.sort(people);
		// Step 1 : Sort List by Last name
		Collections.sort(people, new Comparator<Person>() {

			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		// Step 2 : Create a method that prints all elements in the list
		printAll(people);
		System.out.println("/////////////////////////////////////////////////////");
		// Step 3 : Create a method that prints all people that have last name begining with c
		printConditionally(people , new Condition() {
			public boolean test(Person p) {
				return p.getLastName().startsWith("C") || p.getLastName().startsWith("c");
			}
		});
		System.out.println("/////////////////////////////////////////////////////");
		// Step 4 : Create a method that prints all people that have first name begining with c
		printConditionally(people , new Condition() {
			public boolean test(Person p) {
				return p.getFirstName().startsWith("C") || p.getFirstName().startsWith("c");
			}
		});
	}

	private static void printConditionally(List<Person> people , Condition condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println(p);
		}
	}

	private static void printAll(List<Person> people) {

		for (Person p : people)
			System.out.println(p);
	}
	
	interface Condition{
		boolean test(Person p);
	}
}
