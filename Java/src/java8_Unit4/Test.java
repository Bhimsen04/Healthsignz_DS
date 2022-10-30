package java8_Unit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// int[] arr = { 10, 20, 30, 40, 50, 50, 60, 60, 70 };
		// List lst = Arrays.asList(arr);
		// List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(10, "A"));
		list.add(new Employee(20, "B"));
		list.add(new Employee(30, "C"));
		list.add(new Employee(40, "D"));
		list.add(new Employee(50, "E"));
		list.add(new Employee(60, "E"));
		list.add(new Employee(70, "F"));
		list.add(new Employee(80, "F"));
		list.add(new Employee(90, "F"));

		// Group all employess , with similar names and id > 30?
		Map<String, List<Employee>> m = list.stream().filter(l -> l.id > 30)
				.collect(Collectors.groupingBy(g -> g.name));
		System.out.println(m);

		// Count all employess , with similar names and id > 30?
		Map<String, Long> c = list.stream().filter(l -> l.id > 30)
				.collect(Collectors.groupingBy(g -> g.name, Collectors.counting()));
		System.out.println(c);

		// Find out sum of all the integers less than or equal 40
		int[] arr = { 11, 3, 5, 20, 4, 3, 21 };
		int sum = Arrays.stream(arr).filter(l -> l <= 40).sum();
		System.out.println(sum);

		List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int sum2 = list2.stream().filter(l -> l <= 40).mapToInt(i -> i).sum();
		System.out.println(sum2);

		// Convert list to array based on condition
		int[] ar = list2.stream().filter(l -> l <= 40).mapToInt(i -> i).toArray();
		System.out.println(Arrays.toString(ar));
		System.out.println("***************************************************");
		list2.stream().filter(i -> i <= 5).forEach(i -> System.out.println(i));
		list2.stream().filter(i -> i <= 5).sorted().map(i -> i * i).forEach(i -> System.out.println(i));
		
		Optional<Integer> o = list2.stream().findFirst();
		System.out.println(o);
		
		int v = list2.stream().findFirst().orElse(-1);
		System.out.println(v);
		
		Optional<Integer> o1 = list2.stream().findAny();
		System.out.println(o1);

	}
}
