package java8_Unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java8_Unit1.Unit1ExerciseSolutionJava7.Condition;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList( 
				new Person("ABC", "kohli", 30), 
				new Person("CEF", "czoni", 40),
				new Person("GHI", "yuvi", 50), 
				new Person("CEF", "dhoni", 40), 
				new Person("GHI", "cuvi", 50));
		Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		printConditionally(people , p -> true);
		System.out.println("/////////////////////////////////////////////////////");

		printConditionally(people , p -> p.getLastName().startsWith("C") || p.getLastName().startsWith("c"));
		
		System.out.println("/////////////////////////////////////////////////////");
		printConditionally(people , p -> p.getFirstName().startsWith("C") || p.getFirstName().startsWith("c"));
	}

	private static void printConditionally(List<Person> people , Condition condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println(p);
		}
	}
	
}
