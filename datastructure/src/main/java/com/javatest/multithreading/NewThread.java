package com.javatest.multithreading;

public class NewThread {
	
	public static class Lock {
		boolean isLocked; 
		
	}
	public  static class myTask {
		
		Lock lock;

		public myTask(Lock lock) {
			super();
			this.lock = lock;
		}
		
		
		public void firstTask() {
			synchronized(lock) { 
				System.out.println("first Task started");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lock.notifyAll();
				System.out.println("first Task ends");
			}
			
		}
		
		public void secondTask() {
			synchronized(lock) { 
				System.out.println("second Task started");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.notifyAll();
				System.out.println("second Task ends");
			}
			
		}
		
		public void thirdTask() {
			synchronized(lock) { 
				System.out.println("third Task started");
				
//				try {
//					
//					lock.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				System.out.println("third Task ends");
			}
		}
		
		public void fourthTask() {
			
			synchronized(lock) { 
				System.out.println("fourth Task started");
//				try {
//					//lock.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				System.out.println("fourth Task ends");
			}
			
		}
		
		
public void fifthTask() {
			
			
				System.out.println("fifth Task started");

				System.out.println("fifth Task ends");
			
			
		}
      
		
		
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		final Lock firstLock = new Lock();
		final Lock secondLock = new Lock();
		
		Thread first = new Thread ( new Runnable() {
			@Override
			public void run() {
				myTask task = new myTask(firstLock);
				task.firstTask();
			}
		});
		
		Thread second = new Thread ( new Runnable() {
			@Override
			public void run() {
				myTask task = new myTask(secondLock);
				task.secondTask();
			}
		});
		
		Thread third = new Thread ( new Runnable() {
			@Override
			public void run() {
				myTask task = new myTask(firstLock);
				task.thirdTask();
			}
		});
		
		Thread fourth = new Thread ( new Runnable() {
			@Override
			public void run() {
				myTask task = new myTask(secondLock);
				task.fourthTask();
			}
		});
		
		Thread fifth = new Thread ( new Runnable() {
			@Override
			public void run() {
				myTask task = new myTask(secondLock);
				task.fifthTask();
			}
		});
		
		first.start();
		second.start();
		Thread.sleep(1000);
		third.start();
		fourth.start();
		
			third.join();
			fourth.join();
			
		
		fifth.start();
		
		
		
	}

}
