package com.test;

import java.util.Vector;

public class ProducerConsumerSolution {

	public static void main(String[] args) {
		 int size = 4;
		 Vector<Integer> sharedQueue = new Vector<>();
		Thread t1 = new Thread(new Producer(size,sharedQueue),"Producer");
		Thread t2 = new Thread(new Consumer(size,sharedQueue),"Consumer");
		t1.start();
		t2.start();
	}
}
class Producer implements Runnable {
	private final int size;
	private final Vector<Integer> sharedQueue;
	public Producer(int size, Vector<Integer> sharedQueue) {
		super();
		this.size = size;
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {
		for(int i=0;i<12;i++) {
			System.out.println("produced " +i);
			try {produce(i);}
			catch(InterruptedException e){}
		}
		
	}
	private void produce(int i) throws InterruptedException {
		synchronized(sharedQueue) {
		if(sharedQueue.size()==size) {
			
				System.out.println("SharedQueue is full");
				sharedQueue.wait();
			}
		
			sharedQueue.addElement(i);
			sharedQueue.notifyAll();
		}
	}
}

class Consumer implements Runnable {
	private final int size;
	private final Vector<Integer> sharedQueue;
	public Consumer(int size, Vector<Integer> sharedQueue) {
		super();
		this.size = size;
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {
		while(true) {
			try{
			System.out.println("consumed "+consume());
			}catch(InterruptedException e){}
		}
		
	}
	private Integer consume() throws InterruptedException {
		synchronized(sharedQueue) {
		if(sharedQueue.isEmpty()) {
			
				System.out.println("sharedQueue is Empty");
				sharedQueue.wait();
			}
		
		
			sharedQueue.notifyAll();
			return (Integer)sharedQueue.remove(0);
		}
	}
}