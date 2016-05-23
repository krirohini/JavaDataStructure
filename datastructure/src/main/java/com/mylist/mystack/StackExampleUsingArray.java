package com.mylist.mystack;

//import junit.framework.TestCase;

public class StackExampleUsingArray {

	public static int MAX_SIZE = 5;
	public  int[] stkAry = new int[MAX_SIZE];
	public  int size = 0;
	
	public StackExampleUsingArray () {
		
	}

	public void push(int pushNum) throws IndexOutOfBoundsException {
		if(size >= MAX_SIZE) {
			System.out.println("Stack overFlow...");
			throw new IndexOutOfBoundsException();
		}
		
		System.out.println("Top is at posiotion ..  "+size +"  PUSH  " +pushNum);
		stkAry[size++] = pushNum;	
		printStack();
	}

	public int pop() throws IndexOutOfBoundsException  {
		if(size <= 0) {
			System.out.println("Stack UnderFlow...");
			throw new IndexOutOfBoundsException();
		}else{
			int topVal = stkAry[size-1];
			--size;
			System.out.println("...POP...Now, Position of TOP is .."+size);
			printStack();
			return topVal;
		}
		
	}
	
	public void printStack() {
		System.out.print("Bottom | ");
		for(int i=0; i< size; i++){
			System.out.print(stkAry[i] + "|");
		}
		System.out.println("Top");
	}

	public boolean isEmpty() {
		if(size <= 0){
			System.out.println("STACK is EMPTY");
			return true;
		}
		System.out.println("STACK is not EMPTY");
		return false;
		
	}
	
	public int peek() {
		System.out.println("...PEEK...Top object is "+stkAry[size]);
		return stkAry[size-1];
	}
	
	public boolean search(int num) {
		boolean hasElement=true;
		for(int i=0; i<size; i++) {
			if(stkAry[i]==num){
				System.out.println("Yes, Stack has element  " +num);
				hasElement=true;
				break;
			}else {				
				hasElement=false;
			}
		}
		return hasElement;
	}	
	
	public void getMin(int[] ary) {
		int min = stkAry[0];
		for(int i=1; i<MAX_SIZE-1; i++) {			
			if(min>stkAry[i+1]){
				min=stkAry[i];
			}else{
				min=stkAry[i+1];
			}
		}
		System.out.println("Minimum is .. " +min);
			
		
	}

	public static void main(String[] args) {
		StackExampleUsingArray stk = new StackExampleUsingArray();
		
		
		stk.push(98);
		stk.pop();
		stk.push(838);
		stk.push(7);
		//System.out.println(stkAry);
		stk.pop();
		stk.push(341);
		stk.push(310462);
		stk.peek();
		stk.isEmpty();
		stk.search(7);
		stk.push(23461);
		stk.push(288);
		stk.push(89320);
		//stk.getMin(stkAry);

	}

}
