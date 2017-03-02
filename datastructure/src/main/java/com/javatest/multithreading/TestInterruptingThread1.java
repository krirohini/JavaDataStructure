package com.javatest.multithreading;

class TestInterruptingThread1 extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
			// this will not be executed 
			System.out.println("task");
		} catch (InterruptedException e) {
			// will throw exception
			// throw new RuntimeException("Thread interrupted..." + e);
			// will not throw exception
			System.out.println("Exception handled "+e);  
		}
		System.out.println("thread is running...");  
	}

	public static void main(String args[]) {
		TestInterruptingThread1 t1 = new TestInterruptingThread1();
		t1.start();
		try {
			t1.interrupt();
		} catch (Exception e) {
			System.out.println("Exception handled " + e);
		}

	}
}