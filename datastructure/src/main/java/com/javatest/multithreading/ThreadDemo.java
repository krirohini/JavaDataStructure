package com.javatest.multithreading;
// Java code for thread creation by extending
// the Thread class
class MyThreadDemo extends Thread
{
    public MyThreadDemo(String str) {
		super(str);
	}

	public void run()
    {
        try
        {
            // Displaying the thread that is running
        	System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running and Name is : " +
                    Thread.currentThread().getName());
        	Thread.sleep(10000000);
 
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}


 
// Main Class
public class ThreadDemo
{
    public static void main(String[] args)
    {
    	System.out.println("main thread starts");
        int n = 8; // Number of threads
        for (int i=0; i<8; i++)
        {
            MyThreadDemo object = new MyThreadDemo("MyThreadDemo " + i );
            object.start();
        }
        System.out.println("main thread ends");
    }
}