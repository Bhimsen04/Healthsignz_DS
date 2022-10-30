package java8_Unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java8_Unit1.Person;

public class StandardFunctionalInterfaceExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList( 
				new Person("ABC", "kohli", 30), 
				new Person("CEF", "czoni", 40),
				new Person("GHI", "yuvi", 50), 
				new Person("CEF", "dhoni", 40), 
				new Person("GHI", "cuvi", 50));
		Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		printConditionally(people , p -> true , p -> System.out.println(p));
		System.out.println("/////////////////////////////////////////////////////");

		printConditionally(people , p -> p.getLastName().startsWith("C") || p.getLastName().startsWith("c"), p -> System.out.println(p));
		
		System.out.println("/////////////////////////////////////////////////////");
		printConditionally(people , p -> p.getFirstName().startsWith("C") || p.getFirstName().startsWith("c"), p -> System.out.println(p));
	}

	
	// Perdicate is java inbuilt interface we can can use for specific puropse and then don't need customized interface
	// Consumer is kind of behaviour and it returns nothing
	private static void printConditionally(List<Person> people , Predicate<Person> predicate , Consumer<Person> consumer)  {
		for (Person p : people) {
			if (predicate.test(p))
				consumer.accept(p);
		}
	}

}
