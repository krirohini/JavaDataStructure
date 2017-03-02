package com.javatest.multithreading;

public class AnonymousRunnableDemo {
	public static void main(String[] args) {
		Runnable myRunnable = new Runnable(){

			public void run(){
				System.out.println ("Thread " +
                        Thread.currentThread().getId() +
                        " is running and Name is : " +
                        Thread.currentThread().getName());
			}
		};

		int n = 8; // Number of threads
		for (int i=0; i<8; i++)
		{

			Thread thread = new Thread(myRunnable, "Thread " + i);
			// don't use run as it will run under context of parent thread. 
			//thread.run();
			thread.start();
		}
	}

}
