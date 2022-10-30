package java8_Unit1;

public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("My thread is running!!!!");
			}
		});
		myThread.run();

		Thread myLamdaThread = new Thread(() -> System.out.println("My Thread Created!!!!!!!"));
		myLamdaThread.run();

		Runnable myLambdaRunnable = () -> System.out.println("My Thread Created Once again!!!!!!!");
		myLambdaRunnable.run();
	}
}
