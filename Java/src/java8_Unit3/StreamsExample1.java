package java8_Unit3;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java8_Unit1.Person;

public class StreamsExample1 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("abc", "kohli", 30), new Person("cef", "czoni", 40),
				new Person("ghi", "yuvi", 90), new Person("cef", "dhoni", 60), new Person("ghi", "cuvi", 50));

		people.stream().filter(p -> p.getFirstName().startsWith("c")).forEach(p -> System.out.println(p));

		long count = people.stream().filter(p -> p.getFirstName().startsWith("c")).count();
		System.out.println(count);

		int[] arr = { 1, 2, 3, 5 };
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

		long result = Arrays.stream(arr).filter(i -> i > 1).count();
		System.out.println("\n" + result);

		Stream.of(1, 2, 4).forEach(i -> System.out.println(i + " "));

		Stream.generate(() -> Math.random()).limit(3).forEach(i -> System.out.println(i + " "));
		Stream.iterate(1, n -> n + 1).limit(10).forEach(i -> System.out.println(i + " "));

		people.stream().map(person -> person.getAge()).forEach(age -> System.out.println(age));
		people.stream().mapToDouble(person -> person.getAge()).forEach(age -> System.out.println(age));

		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = Arrays.asList(5, 6, 7);

		Stream.of(l1, l2).flatMap(list -> list.stream()).filter(num -> num > 2 && num < 7)
				.forEach(list -> System.out.println(list));

		// people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(p
		// -> System.out.println(p));
		people.stream().sorted((a, b) -> {
			if (a.getAge() == b.getAge())
				return 0;
			else if (a.getAge() > b.getAge())
				return 1;
			else
				return -1;
		}).forEach(p -> System.out.println(p));

		boolean b = people.stream().anyMatch(a -> a.getAge() > 40);
		System.out.println(b);

		boolean b2 = people.stream().allMatch(a -> a.getAge() > 40);
		System.out.println(b2);

		boolean b3 = people.stream().noneMatch(a -> a.getAge() > 410);
		System.out.println(b3);

		Person p = people.stream().filter(a -> a.getAge() > 50).findFirst().get();
		System.out.println(p);
		p = people.stream().filter(a -> a.getAge() > 90).findFirst().orElse(null);
		System.out.println(p);

		int t = people.stream().map(m -> m.getAge()).reduce(0, Integer::sum);
		System.out.println(t);

		Set<Integer> l = people.stream().filter(m -> m.getAge() > 10).map(m -> m.getAge()).collect(Collectors.toSet());
		System.out.println(l);
		System.out.println(people);
		Map<Integer, Person> map = people.stream().filter(m -> m.getAge() > 10)
				.collect(Collectors.toMap(Person::getAge, m -> m));
		System.out.println(map);

		map = people.stream().filter(m -> m.getAge() > 10)
				.collect(Collectors.toMap(Person::getAge, Function.identity()));
		System.out.println(map);

		IntSummaryStatistics total = people.stream().filter(m -> m.getAge() > 10)
				.collect(Collectors.summarizingInt(Person::getAge));
		System.out.println(total);

		String s = people.stream().filter(m -> m.getAge() > 10).map(Person::getFirstName)
				.collect(Collectors.joining(" ,"));
		System.out.println(s);

		List<Movie> movies = Arrays.asList(new Movie("a", 10, Genre.THRILLER), new Movie("b", 20, Genre.ACTION),
				new Movie("c", 30, Genre.ACTION));
		Map<Genre, List<Movie>> movieList = movies.stream().collect(Collectors.groupingBy(Movie::getGenre));
		System.out.println(movieList);
		Map<Genre, Set<Movie>> movieSet = movies.stream()
				.collect(Collectors.groupingBy(Movie::getGenre, Collectors.toSet()));
		System.out.println(movieSet);
		Map<Genre, Long> movieCounts = movies.stream()
				.collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
		System.out.println(movieCounts + "\n");
		Map<Genre, String> movieNameJoins = movies.stream().collect(
				Collectors.groupingBy(Movie::getGenre, Collectors.mapping(Movie::getTitle, Collectors.joining("-"))));
		System.out.println(movieNameJoins);
		Map<Boolean, String> partitioning = movies.stream().collect(Collectors.partitioningBy(m -> m.getLikes() > 10,
				Collectors.mapping(Movie::getTitle, Collectors.joining(","))));
		System.out.println(partitioning);
		
		IntStream.rangeClosed(1, 10).forEach(m -> System.out.println(m));
	}
}
