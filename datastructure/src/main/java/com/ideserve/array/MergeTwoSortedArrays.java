package com.ideserve.array;

import java.util.Arrays;

/**
 * http://www.ideserve.co.in/learn/merge-two-sorted-arrays-without-extra-space
 * Given two sorted arrayA and arrayB such that arrayA has enough void spaces
 *  in it to be able to accommodate arrayB in it. Void spaces in an array are denoted using
 *   INVALID_NUM. Write a program to merge arrayB into arrayA such that resulting array is a sorted array. 
 *   The expected space complexity is O(1).  
 *   For example, if 
 *   arrayA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM}
 *    and arrayB = {-1, 2, 6, 12}
 *    then arrayS should be modified to 
 *    array - {-3, -1, 2, 5, 6, 7, 10, 11, 12}
 *
 */
public class MergeTwoSortedArrays {
	final static int INVALID_NUM = 0;
	
	public static void inplaceMergeArrays(int[] arrayA, int[] arrayB)
    {
		// move all elements of arrayA with valid values towards the end
        int validNumIndex = arrayA.length - 1;
        for (int i = arrayA.length - 1; i >= 0; i--)
        {
            if (arrayA[i] != INVALID_NUM)
            {
                arrayA[validNumIndex] = arrayA[i];
                validNumIndex -= 1;
            }
        }
        
//		System.out.println(Arrays.toString(arrayA));
//		System.out.println(validNumIndex);
		
		
		int i = validNumIndex + 1;
		int j = 0 , k =0; 
		
		while (  (i <arrayA.length  ) && (j < arrayB.length)) { 
			if(arrayA[i] < arrayB[j]) {
				arrayA[k++] = arrayA[i++];
			
			} 
			else {
				arrayA[k++] = arrayB[j++];
				
			}
		}
		
		while ( j < arrayB.length) {
			arrayA[k++] = arrayB[j++];
		}
		
    }
	public static void main(String[] args) {
		int [] arrayA = new int []{-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM};
		int [] arrayB =  new int [] {-1, 2, 6, 12};
		
		int [] expectedArray = new int[] { -3, -1, 2,5,6,7,10,11,12}; 
		
		System.out.println("First Array " + Arrays.toString(arrayA));
		System.out.println("Second Array " + Arrays.toString(arrayB));
		System.out.println("Expected Array " + Arrays.toString(expectedArray));

		
		inplaceMergeArrays(arrayA, arrayB);
		
		System.out.println("Result array " + Arrays.toString(arrayA));
	}
	

}
