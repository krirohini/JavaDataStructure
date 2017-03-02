package com.javatest.multithreading;
class Table{  
	synchronized static  void staticPrintTable(int n){  
		for(int i=1;i<=10;i++){  
			System.out.println(n*i);  
			try{  
				Thread.sleep(400);  
			}catch(Exception e){}  
		}  
	} 

	synchronized  void printTable(int n){  
		for(int i=1;i<=10;i++){  
			System.out.println(n*i);  
			try{  
				Thread.sleep(400);  
			}catch(Exception e){}  
		}  
	}  
}  

class MyThread1 extends Thread{  
	Table t;  
	boolean isStatic = false;
	MyThread1(Table t, boolean isStatic){  
		this.isStatic = isStatic;	
		this.t=t;
	}  
	public void run(){  
		if(isStatic) { 
			Table.staticPrintTable(1); 
		} else { 
			t.printTable(1);
		}
	}  
}  

class MyThread2 extends Thread{  
	Table t;  
	boolean isStatic = false;
	MyThread2(Table t, boolean isStatic){  
		this.isStatic = isStatic;	
		this.t=t;
	}  
	public void run(){  
		if(isStatic) { 
			Table.staticPrintTable(10); 
		} else { 
			t.printTable(10);
		}
	}
}  

class MyThread3 extends Thread{ 
	Table t;  
	boolean isStatic = false;
	MyThread3(Table t, boolean isStatic){  
		this.isStatic = isStatic;	
		this.t=t;
	}  
	public void run(){  
		if(isStatic) { 
			Table.staticPrintTable(100); 
		} else { 
			t.printTable(100);
		}
	}
}  




class MyThread4 extends Thread{
	Table t;  
	boolean isStatic = false;
	MyThread4(Table t, boolean isStatic){  
		this.isStatic = isStatic;	
		this.t=t;
	}  
	public void run(){  
		if(isStatic) { 
			Table.staticPrintTable(1000); 
		} else { 
			t.printTable(1000);
		}
	}
}  

public class TestSynchronization4{  
	public static void main(String t[]){  
		Table obj1 = new Table();//only one object 
		Table obj2 = new Table();//only one object 
		boolean isStatic = true; 
		MyThread1 t1=new MyThread1(obj1,isStatic);  
		MyThread2 t2=new MyThread2(obj1,isStatic);  
		MyThread3 t3=new MyThread3(obj2,isStatic);  
		MyThread4 t4=new MyThread4(obj2, isStatic);  
		t1.start();  
		t2.start();  
		t3.start();  
		t4.start();  
	}  
}  