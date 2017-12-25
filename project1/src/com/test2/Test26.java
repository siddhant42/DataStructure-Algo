package com.test2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test26{

	// nTasks will be executed using-
	// maximum of nThreads in case of newFixedThreadPool
	// maximum of tTasks no of threads will be used in case of newCachedThreadPool
	//private static final int nThreads = 5;
	private static final int tTasks = 30;
	private static final ThreadPoolExecutor ex = (ThreadPoolExecutor)Executors.newCachedThreadPool();
			//Executors.newCachedThreadPool();
	public static void main(String[] args) throws Exception {
		for(int i=0;i<tTasks;i++) {
			int p = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+" running task "+p);
					try {
						System.out.println(Thread.currentThread().getName()+" in sleep");
						Thread.sleep(1000);
						//ex.shutdownNow();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			ex.submit(task);
			System.err.println("current no of threads "+ex.getActiveCount());
		}
		// JVM will not stop untill we shutdown the executorService
//		ex.shutdown();
//		System.out.println("service shutdown is called "+ex.isShutdown());
//		ex.awaitTermination(5000,TimeUnit.MILLISECONDS);
//		System.out.println("Is service terminated? "+ex.isTerminated());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("current no of threads "+ex.getActiveCount());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("current no of threads "+ex.getActiveCount());
	}

}
