package com.javatest.queue;

public class MultiarrayStack {
	
	int stackSize = 100; 
	int [] buffer = new int [stackSize * 3];
	int [] stackTopIndex = new int [] { -1,-1,-1};
	
	/* returns index of top of stack "stackNurrr"J in absolute terms */
	 int absTopOfStack(int stackNum) {
		 return ( stackNum * stackSize + stackTopIndex[stackNum]);
	 }
	 
	 boolean isEmpty( int stackNum) {
		 if(stackTopIndex[stackNum] == -1) {
			 return true;
		 }
		 return false;
	 }
	 
	 int peek( int stackNum) {
		 return buffer[absTopOfStack(stackNum)];
	 }

	 void push(int stackNum, int value) throws Exception {
		 if(stackNum > 3) {
			 throw new IllegalArgumentException("Only 3 Stacks");
		 }
		 
		if( stackTopIndex[stackNum] + 1 > stackSize) {
			throw new IllegalArgumentException("Stacks overflow");
		}
		stackTopIndex[stackNum]++;
		 int abIndex = absTopOfStack(stackNum); 
		 buffer[abIndex] = value;
	 }
	 
	 int pop(int stackNum) throws Exception {
		 
		 if(stackNum > 3) {
			 throw new IllegalArgumentException("Only 3 Stacks");
		 }
		 
		 if(stackTopIndex[stackNum] == -1 ) {
			 throw new Exception("Empty Stack"); 
		 }
		 
		 int abIndex = absTopOfStack(stackNum);
		 int value = buffer[abIndex];
		 buffer[abIndex] = 0;
		 stackTopIndex[stackNum]--;
		 return value;
	 }
}
