package com.javatest.recursion;

public class MagicIndex {

	public static int getMagicIndex(int[] arr, int start, int end) {
		
		try { 
			if( start > end || start < 0 || end >= arr.length) {
				return -1; 
			}

			int mid = (start + end) / 2; 
			if( arr[mid] == mid ) {
				return mid;
			} else if (arr[mid] > mid ) {
				return  getMagicIndex(arr, start , mid-1) ;
			} else {
				return getMagicIndex(arr, mid +1 , end) ;
			}

		} catch ( Exception ex) {
			System.out.println(ex.getMessage());
		}

		return -1;
	}
	
	public static void main(String[] args) {
		
		int [] arr = new int[] {-40,-20,-1, 1, 2,3,5, 7, 9, 12, 13};
		
		int magicIndex = getMagicIndex( arr, 0 , arr.length -1);
		System.out.println("magicIndex is : " + magicIndex);
		
	}
}
