package java8_Unit1;

public class Greeter {
	public static void main(String[] args) {
		// Lambda expression
		Greeting lambdaGreeting = () -> System.out.println("Hello world!");
		lambdaGreeting.perform();
		System.out.println(lambdaGreeting.myString("Hello"));
		// Anonymous inner class
		Greeting innerClassGreeting = new Greeting() {
			public void perform() {
				System.out.println("Bhimsen");

			}
		};
		innerClassGreeting.perform();
		greet(lambdaGreeting);
		greet(innerClassGreeting);
	}

	public static void greet(Greeting greeting) {
		greeting.perform();
	}
}
