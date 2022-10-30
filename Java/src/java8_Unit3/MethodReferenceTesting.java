package java8_Unit3;

public class MethodReferenceTesting {

	public static void main(String[] args) {

		Person p = (a, b) -> print(a, b);
		Person p2 = MethodReferenceTesting::print;
		p.getPerson(5, 10);
		p2.getPerson(8, 8);
		p = (a, b) -> prints();
		// This we can't execute because prints didn't have same no. of parameters as a interface method
		// p2 = methodReferenceTesting::prints;

	}

	public static void print(int a, int b) {
		System.out.println(a + b);
	}

	public static void prints() {
		System.out.println("Hello");
	}

	interface Person {
		void getPerson(int p, int q);
	}
}
