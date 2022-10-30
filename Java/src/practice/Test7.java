package practice;

public class Test7 {

	static int m = 20;

	public static void main(String[] args) {
		System.out.println("main");
		Test7 test1 = new Test7();
		Test7 test2 = new Test7();
	}

	{
		System.out.println("non - static block");
	}

	static {
		System.out.println(m + " static block");
	}

	public static void m1() {
		System.out.println("m1");
	}
}
