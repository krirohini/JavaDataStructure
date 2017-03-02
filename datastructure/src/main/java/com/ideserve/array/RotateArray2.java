package com.ideserve.array;

import java.util.Arrays;

/**
 * http://www.ideserve.co.in/learn/rotate-an-array
 *
 */
public class RotateArray2 {
	private void reverseList(int[] arr, int start, int end) {
		
		if( arr == null && (start >= end)) {
			return;
		}
		
		int mid = (start + end) /2; 
		
		while ( start <= mid) {
			int temp = arr[start];
			arr[start] = arr[end ];
			arr[end ] = temp;
			start ++;
			end --;
		}
//		for ( int i = start ; i<= mid ; i++) { 
//			int temp = arr[i];
//			arr[i] = arr[end + start-i];
//			arr[end + start-i] = temp;
//		}
		
	}
	
	   public static void rotateArrayNaive(int[] array, int move) {
		   
		   if(move < 0 ) {
			   throw new IllegalArgumentException("move can't be negative"); 
		   }
		   
		   if( null == array || array.length < 2 ) {
			   return; 
		   }
		   
		   if(move > array.length) {
			   move = move % array.length;
		   }
		   
		   for ( int i = 0 ; i < move; i++) {
			   rotateArrayOnce(array);
		   }
		   
	   }
	
	public static void rotateArrayOnce(int[] array) {
		int length = array.length;
		int temp = array[0];
		
		for( int i = 0 ; i < length-1 ; i ++) {
			array[i] = array[i+1]; 
		}
		array[length-1] = temp;
	}
	
	public static void rotateArrayUsingTmp(int[] array, int move) {
		
		if( move < 0 ) { 
			throw new IllegalArgumentException("move can't be negative");
		}
		
		if( null == array || array.length < 2) { 
			return;
		}
		
		if( move > array.length) { 
			move = move % array.length;
		}
		
		int [] tempArray = new int[move];
		
		for( int i = 0; i < move; i ++) {
			tempArray[i] = array[i];
		}
		
		for(int i = move ; i < array.length ; i++) { 
			array[i-move] = array[i];
		}
		
		for(int i = array.length - move ; i < array.length ; i++  ) {
			array[i] = tempArray[i - (array.length - move)] ; 
		}
		
	}
	
	// Driver program to test above functions
    public static void main(String[] args) {
        RotateArray2 rotate = new RotateArray2();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int move = 3; 
        System.out.println(Arrays.toString(arr));
//        rotate.leftRotate(arr, move);
//        System.out.println(Arrays.toString(arr));
        
       // rotateArrayNaive(arr, move);
        rotateArrayUsingTmp(arr, move);
        System.out.println(Arrays.toString(arr));
        
      
    }

	private void leftRotate(int[] arr, int move) {
		
		if(move < 0) {
			throw new IllegalArgumentException("Move can't be negative");
		}
		if( arr == null  || arr.length < 2) {
			return;
		}
		
		if(move > arr.length) { 
			move = move % arr.length;
		}
		
		this.reverseList(arr, 0, move-1 );
		this.reverseList(arr, move , arr.length-1);
		this.reverseList(arr, 0, arr.length-1);
	}

}
