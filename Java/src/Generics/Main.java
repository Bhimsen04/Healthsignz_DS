package Generics;

public class Main {
	public static void main(String[] args) {
		GenericList<Integer> g = new GenericList<>();
		g.add(1);
		g.add(2);

		System.out.println(g.count);

		GenericList<String> g2 = new GenericList<>();
		g2.add("1");
		g2.add("2");
		g2.add("3");
		g2.add("4");

		System.out.println(g2.count);

	}
}
