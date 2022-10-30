package java8_Unit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
	public static void main(String[] args) {
//		Random random = new Random();
//		random.ints(1, 25).limit(5).forEach(System.out::println);

		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		// Added the numbers into Arraylist
		System.out.println(sum(list));

		// Find square of numbers && greater than 100

		List<Integer> list2 = square(list);
		System.out.println(list2);

		// find lowest
		int lowest = getLowest(list);
		System.out.println("Lowest :- " + lowest);

		// find highest
		int highest = getHighest(list);
		System.out.println("highest :- " + highest);

		List<List<String>> Names = Arrays.asList(Arrays.asList("Saket", "STrevor"), Arrays.asList("John", "Michael"),
				Arrays.asList("Shawn", "Franklin"), Arrays.asList("Johnty", "Sean"));

		/*
		 * flatMap Stream operation is used for more complex Stream operation. Here we
		 * have carried out flatMap operation on “List of List of type String”
		 */

		// we have filtered out the names which start with ‘S’.
		flatMap(Names);

		int arr[] = { 99, 55, 203, 99, 4, 91 };
		sortArray(arr);
		System.out.println();
		List<String> list3 = Arrays.asList("Java", "8");
		List<String> list4 = Arrays.asList("explained", "through", "programs");
		concateTwoLists(list3, list4);
		System.out.println();
		int arr2[] = { 1, 9, 8, 7, 7, 8, 9 };
		removeDuplicates(arr2);

	}

	private static void removeDuplicates(int[] arr2) {
		Arrays.stream(arr2).distinct().sorted().forEach(str -> System.out.print(str + " "));
		System.out.println();
		Arrays.stream(arr2).boxed().collect(Collectors.toSet()).forEach(str -> System.out.print(str + " "));

	}

	private static void concateTwoLists(List<String> list3, List<String> list4) {
		Stream.concat(list3.stream(), list4.stream()).forEach(str -> System.out.print(str + " "));
	}

	private static void sortArray(int[] arr) {
		Arrays.stream(arr).sorted().forEach(n -> System.out.print(n + " "));

	}

	private static void flatMap(List<List<String>> names) {
		names.stream().flatMap(name -> name.stream()).filter(s -> s.startsWith("S"))
				.forEach(name -> System.out.println(name));
	}

	private static int getLowest(ArrayList<Integer> list) {
		return list.stream().min(Comparator.comparing(i -> i)).get();
	}

	private static int getHighest(ArrayList<Integer> list) {
		return list.stream().max(Comparator.comparing(i -> i)).get();
	}

	private static List<Integer> square(ArrayList<Integer> list) {
		return list.stream().map(i -> i * i).filter(i -> i > 100).collect(Collectors.toList());
	}

	private static int sum(ArrayList<Integer> list) {
		return list.stream().mapToInt(i -> i).sum();
	}
}
