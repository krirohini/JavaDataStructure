package com.javatest.array;

import java.util.Arrays;

public class ArraySum {

	public static void main(String[] args) {
		int [] arr = new int [] { 2,3,4,5,6}; 
		System.out.println(Arrays.toString(arr));
		
		int arraySum = 0; 
		
		for ( int cur : arr) {
			arraySum = arraySum + cur; 
		}
		
		for ( int cur = 0; cur < arr.length ; cur++) {
			arr[cur] = arraySum - arr[cur]; 
		}
		
		System.out.println(Arrays.toString(arr));
		
		

	}

}
