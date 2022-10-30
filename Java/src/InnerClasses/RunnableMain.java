package InnerClasses;

public class RunnableMain {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable() {
			@Override
			public void run() {
				for (int i = 5; i < 10; i++)
					System.out.println(i);
			}
		};

		Thread t = new Thread(myRunnable);
		t.start();

		MyThread th2 = new MyThread();
		th2.start();

		for (int i = 10; i < 15; i++)
			System.out.println(i);

		new Thread(new MyRunnable() {
			@Override
			public void run() {
				for (int i = 15; i < 20; i++)
					System.out.println(i);
			}
		}).start();
	}
}
