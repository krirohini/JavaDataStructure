package com.javatest.multithreading;

//A Java program to demonstrate working of
//synchronized.
import java.io.*;
import java.util.*;

//A Class used to send a message
class Sender
{
	public void send(String msg)
	{
		System.out.println("Sending\t"  + msg );
		try
		{
			Thread.sleep(1000);
		}
		catch (Exception e)
		{
			System.out.println("Thread  interrupted.");
		}
		System.out.println("\n" + msg + "Sent");
	}
	
	/**
	 * Never mix non static and static synchronized methods,
	 * 
	 * @param msg
	 */
	
	public static synchronized void sendSynchronizedStaticMethod(String msg)
    {
        System.out.println("Sending\t" + msg );
        try
        {
            Thread.sleep(1000);
        } 
        catch (Exception e) 
        {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    } 
	
	// synchronized Method
	// Static function : acquire class level  lock  
	// Non Static function : acquire object level  lock  
	// put the lock on object 
	// An alternate implementation to demonstrate
	// that we can use synchronized with method also.
	//less concurrant 
	public synchronized void sendSynchronizedNonStaticMethod(String msg)
    {
        System.out.println("Sending\t" + msg );
        try
        {
            Thread.sleep(1000);
        } 
        catch (Exception e) 
        {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
	
	/**synchronized block 
	 * synchronized block locks on monitor evaluated by expression 
	 * provided as parameter to synchronized block
	 * Read more: http://www.java67.com/2013/01/difference-between-synchronized-block-vs-method-java-example.html#ixzz4Xfm7lLvm 
	 *
	 *it is preferable to synchronize only part of a method.
	 * flexibile as you can use other object as lock 
	 * lock is only limited to block execution 
	 *whereas synchronized Method will acquire obect level lock 
	 * 
	 * Pros: 
	 * 	reduce scope of lock
	 * 	granular control over lock,
	 * 
	 */
	public void sendSynchronizedNonStaticBlock(String msg)
    {
        synchronized(this)
        {
            System.out.println("Sending\t" + msg );
            try
            {
                Thread.sleep(1000);
            } 
            catch (Exception e) 
            {
                System.out.println("Thread interrupted.");
            }
            System.out.println("\n" + msg + "Sent");
        }
    }
}

//Class for send a message using Threads
class ThreadedSend extends Thread
{
	private String msg;
	private Thread t;
	Sender  sender;

	// Recieves a message object and a string
	// message to be sent
	ThreadedSend(String m,  Sender obj)
	{
		msg = m;
		sender = obj;
	}

	public void run()
	{
		// Only one thread can send a message at a time.
		synchronized(sender)
		{
			// synchronizing the snd object
			sender.send(msg);
		}
	}
}

//Driver class
public class SyncronizationDemo
{
	public static void main(String args[])
	{
		System.out.println("main thread starts");
		Sender snd = new Sender();
		ThreadedSend S1 =
				new ThreadedSend( " Hi " , snd );
		ThreadedSend S2 =
				new ThreadedSend( " Bye " , snd );

		// Start two threads of ThreadedSend type
		S1.start();
		S2.start();

		// wait for threads to end
		try
		{
			//Waits for this thread to die.
			S1.join();
			S2.join();
		}
		catch(Exception e)
		{
			System.out.println("Interrupted");
		}
		System.out.println("main thread Ends");
	}
}

