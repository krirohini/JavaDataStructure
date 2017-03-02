package com.javatest.multithreading;

//Java code for thread creation by implementing
//the Runnable Interface
 class MyRunnable implements Runnable {

	@Override
	public void run() {
		try
        {
            // Displaying the thread that is running
			System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running and Name is : " +
                    Thread.currentThread().getName());
 
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
		
	}

}

public class RunnableDemo {
	 public static void main(String[] args)
	    {
		 System.out.println(Thread.currentThread().getName());
	        int n = 8; // Number of threads
	        for (int i=0; i<8; i++)
	        {
	            //Thread object = new Thread(new MyRunnable());
	            Thread object = new Thread(new MyRunnable(), "MyThreadRunnable " + i);
	            object.start();
	        }
	    }
}


