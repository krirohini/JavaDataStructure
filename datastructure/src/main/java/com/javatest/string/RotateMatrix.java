package com.javatest.string;

import java.util.Arrays;

public class RotateMatrix {

	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				// save top
				int top = matrix[first][i];
				// top <= left 
				matrix[first][i] = matrix[last-offset][first];

				// left <= bottom 
				matrix[last-offset][first] = matrix[last][last - offset];

				// bottom <= right 
				matrix[last][last - offset] = matrix[i][last];

				// right <= top 
				matrix[i][last] = top;
			}
		}
	}
	
	public static void print (int[][] matrix) {
		for( int [] subArray : matrix) { 
			System.out.println(Arrays.toString(subArray));
			} 
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int [] [] {
			{1,2,3} ,
			{4,5,6},
			{7,8,9}
		};
		print(matrix);
		
		System.out.println(Arrays.toString(matrix[1]));
		System.out.println(matrix[0][2]);
		
//		rotate(matrix, 3);
//		print(matrix);
	}
}
