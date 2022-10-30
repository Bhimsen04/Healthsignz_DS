package com.executor.runnablejob;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintJob implements Runnable {

	private String name;

	public PrintJob(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + "...Job started by Thread:" + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "...Job completed by Thread:" + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		PrintJob[] jobs = { new PrintJob("Bhimsen1"), new PrintJob("Bhimsen2"), new PrintJob("Bhimsen3"),
				new PrintJob("Bhimsen4"), new PrintJob("Bhimsen5"), new PrintJob("Bhimsen6") };
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (PrintJob job : jobs)
			service.submit(job);
		service.shutdown();
	}

}
