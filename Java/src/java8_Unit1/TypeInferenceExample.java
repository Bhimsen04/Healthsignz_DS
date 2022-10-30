package java8_Unit1;

public class TypeInferenceExample {
	public static void main(String[] args) {
		printLength(s -> s.length());
	}

	public static void printLength(StringLengthLamda lamda) {
		System.out.println(lamda.getLength("bhimsen"));
	}

	interface StringLengthLamda {
		int getLength(String s);
	}
}
