package com.javatest.array;

import java.util.Arrays;
import java.util.Stack;

public class RotateArray {
	
	
	
	// Driver program to test above functions
    public static void main(String[] args) {
        RotateArray rotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        rotate.leftRotate(arr, 2);
        System.out.println(Arrays.toString(arr));
        rotate.leftRotate2(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int [] arr, int start, int end) {
    	
    	
        end--;
        if(start >= end) {
            return;
        }
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end --;
        }
    }
    
    public static void leftRotate2(int [] arr, int rotation) {
        
        reverseArray(arr, 0, rotation);
        reverseArray(arr,  rotation, arr.length);
        reverseArray(arr,  0, arr.length);
    }
    
	private void leftRotate(int[] arr,  int pos) {
		int[] tempArr = new int[pos]; 
		
		for( int i = 0; i < pos; i ++) { 
			tempArr[i] = arr[i]; 
		}
		
		for( int i = 0; i < ( arr.length - pos) ; i++ ) {
			arr[i] = arr[i+pos]; 
		}
		
		for(int i = ( arr.length - pos), j =0; i < arr.length  ; i++ , j++) {
			arr[i] = tempArr[j];
		}
		
		
	}
	
	private void rightRotate(int[] arr,  int pos) {
		int[] tempArr = new int[pos]; 
		
		for( int i =0 , j= arr.length-1; i < pos; i ++, j--) { 
			tempArr[i] = arr[j]; 
		}
		
		for( int i = 0; i < ( arr.length - pos) ; i++ ) {
			arr[i] = arr[i+pos]; 
		}
		
		for(int i = ( arr.length - pos), j =0; i < arr.length  ; i++ , j++) {
			arr[i] = tempArr[j];
		}
		
		
	}

}
