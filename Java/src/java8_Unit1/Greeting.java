package java8_Unit1;

@FunctionalInterface
public interface Greeting {
	public void perform();

	public default String myString(String s) {
		return s;
	}

	public static int myString(int n) {
		return 0;
	}
}
