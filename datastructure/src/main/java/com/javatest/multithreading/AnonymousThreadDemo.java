package com.javatest.multithreading;

public class AnonymousThreadDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		int n = 8; // Number of threads
		for (int i=0; i<8; i++)
		{
			Thread thread = new Thread(){
				public void run(){
					System.out.println ("Thread " +
	                        Thread.currentThread().getId() +
	                        " is running and Name is : " +
	                        Thread.currentThread().getName());
				}
			};

			thread.start();
		}

	}

}
