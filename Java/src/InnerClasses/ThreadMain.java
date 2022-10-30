package InnerClasses;

public class ThreadMain {
	public static void main(String[] args) {
		MyThread th = new MyThread() {
			@Override
			public void run() {
				for (int i = 5; i < 10; i++)
					System.out.println(i);
			}
		};
		th.start();

		MyThread th2 = new MyThread();
		th2.start();

		for (int i = 10; i < 15; i++)
			System.out.println(i);
	}
}
