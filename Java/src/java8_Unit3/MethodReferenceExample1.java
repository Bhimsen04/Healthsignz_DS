package java8_Unit3;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		// Using Lambda
		Thread thread = new Thread(() -> printMessage());
		// using methodReference
		thread = new Thread(MethodReferenceExample1::printMessage);
		thread.start();
	}

	public static void printMessage() {
		System.out.println("Welcome g");
	}

}
