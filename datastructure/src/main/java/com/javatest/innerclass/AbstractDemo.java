package com.javatest.innerclass;



public class AbstractDemo extends AbstractBaseDemo {
	 public static void main(String[] args) {
		 AbstractDemo obj = new AbstractDemo();
		 obj.print();
		
		 
		 System.out.println(InterfaceDemo.val3);
		 
		}

	@Override
	void operation() {
		// TODO Auto-generated method stub
		
	}
}


 abstract class AbstractBaseDemo {
	public int value = 10;
	abstract void operation();
	/** error Abstract methods do not specify a body
	abstract void operation2 () {
		
	}
	*/ 
	
	void print(){
		System.out.println(value);
	}
	
	
}

