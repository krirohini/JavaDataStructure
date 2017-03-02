package com.javatest.innerclass;

/**
 * http://www.javatpoint.com/static-nested-class 
 * A static class i.e. created inside a class is called static nested class in java.
 *  It cannot access non-static data members and methods.
 *   It can be accessed by outer class name.
 * 
 * It can access static data members of outer class including private. Static
 * nested class cannot access non-static (instance) data member or method
 *
 */
public class staticNested {
	static private int data = 30;

	static class Inner {
		void msg() {
			System.out.println("memebr method: data is " + data);
		}
		
		static void staticMsg() {
			System.out.println("static method : data is " + data);
		}
	}

	public static void main(String args[]) {
		staticNested.Inner obj = new staticNested.Inner();
		obj.msg();
		
		Inner obj2 = new Inner();
		obj2.msg();
		
		Inner.staticMsg();
	}
}
