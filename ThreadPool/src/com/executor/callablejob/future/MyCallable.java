package com.executor.callablejob.future;

import java.util.concurrent.*;

public class MyCallable implements Callable {

	private int num;

	public MyCallable(int num) {
		this.num = num;
	}

	@Override
	public Object call() {
		System.out.println(Thread.currentThread().getName() + " sum of first " + num + " numbers");
		int sum = 0;
		for (int i = 0; i <= num; i++)
			sum += i;
		return sum;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable[] jobs = { new MyCallable(10), new MyCallable(20), new MyCallable(30), new MyCallable(40),
				new MyCallable(50), new MyCallable(60) };
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (MyCallable job : jobs) {
			Future f = service.submit(job);
			System.out.println(f.get());
		}
		service.shutdown();
	}

}
