package practice;

public class Demo {

	public static void main(String[] args) {
		Enums en = Enums.E;
		System.out.println(en);
	}

}

enum Enums {
	D, E, S;
	Enums() {
		System.out.println(20);
	}
}
