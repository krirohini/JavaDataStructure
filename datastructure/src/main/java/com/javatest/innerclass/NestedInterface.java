package com.javatest.innerclass;

/**
 * 
 * An interface i.e. declared within another interface or class is known as
 * nested interface. The nested interfaces are used to group related interfaces
 * so that they can be easy to maintain. The nested interface must be referred
 * by the outer interface or class. It can't be accessed directly.
 * 
 * Points to remember for nested interfaces
 * 
 * There are given some points that should be remembered by the java programmer.
 * 
 * Nested interface must be public if it is declared inside the interface but it
 * can have any access modifier if declared within the class. Nested interfaces
 * are declared static implicitely.
 * 
 *
 */

interface Showable {
	void show();

	interface Message {
		void msg();
	}
}

 public class NestedInterface implements Showable.Message {
	public void msg() {
		System.out.println("Hello nested interface");
	}

	public static void main(String args[]) {
		Showable.Message message = new NestedInterface();// upcasting here
		message.msg();
	}
}
