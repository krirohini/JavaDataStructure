package com.javatest.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * http://n00tc0d3r.blogspot.com/2013/05/set-matrix-to-zeroes.html?view=flipcard
 * So, we iterate through the matrix twice. In the first iteration, we find out
 * all of the zeroes and store their row and column numbers. In the next
 * iteration, we set a cell to zero if it is on a row or a column that we
 * stored.
 *
 */

public class SetMatrixRowColumnZero {
	
	/**
	 * Step1: Does first row have zero?
	 * step2 : Does first column have zero? 
	 * step3 :find zeroes and store the info in first row and column 
	 * step 4: set zeroes except the first row and column 
	 * setp5 :set zeroes for first row and column if needed 
	 * Space complexity : optimized o(1) 
	 * Time Complexity : o(n^2)
	 */
	public static void setMatrixZeroInPlace (int [] [] matrix) {
		if(matrix == null) {
			return;
		}
		
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		
		if(rowNum == 0 || colNum == 0) {
			return;
		}
		
		boolean isFirstRowHasZero = false; 
		boolean isFirstColHasZero = false; 
		// Step1: Does first row have zero? 
		for( int col = 0 ; col < colNum; col++) {
			if(matrix[0][col] == 0) {
				isFirstRowHasZero = true;
				break;
			}
		}
		
		// step2 : Does first column have zero? 
		for(int row =0 ; row < rowNum ; row++) {
			if(matrix[row][0] == 0) {
				isFirstColHasZero = true;
				break;
			}
		}
		
		// step3 :find zeroes and store the info in first row and column 
		for(int row = 1 ; row < rowNum ; row++) {
			for ( int col =1; col < colNum; col++) {
				if(matrix[row] [col] == 0) {
					matrix[row] [0] = 0;
					matrix[0] [col] = 0; 
				}
			}
		}
		
		//step 4: set zeroes except the first row and column  
		for(int row = 1 ; row < rowNum ; row ++) {
			for(int col =1; col < colNum ; col++) {
				if( (matrix[0] [col] == 0) || (matrix[row][0] == 0) ) {
					matrix[row][col] = 0;
				}
			}
		}
		
		//setp5 :set zeroes for first row and column if needed  
		if(isFirstRowHasZero) {
			for( int col = 0 ; col < colNum; col++) {
				matrix[0][col] = 0;
			}
		}
		
		if(isFirstColHasZero) {
			for(int row =0 ; row < rowNum; row++) {
				matrix[row][0] = 0;
			}
		}
		
	}
	
	/**
	 * Space complexity : optimized o(1) 
	 * Time Complexity : o(n^2)
	 */
	public static void setMatrixZero (int [] [] matrix) {
		if(matrix == null) {
			return;
		}
		
		Set <Integer> rowSet = new HashSet<>();
		Set <Integer> columnSet = new HashSet<>();
		
		for ( int row = 0 ; row < matrix.length ; row++) {
			for ( int column = 0 ; column < matrix[0].length ; column++) {
				if(matrix[row] [column] == 0) {
					rowSet.add(row);
					columnSet.add(column);
				}
			}
		}
		 // set zeroes 
		for ( int row = 0 ; row < matrix.length ; row++) {
			for ( int column = 0 ; column < matrix[0].length ; column++) {
				if(rowSet.contains(row) || columnSet.contains(column)) {
					matrix[row] [column] = 0;
				}
			}
		}
	}
	public static void printMatrix(String message, int [] [] matrix) {
		System.out.println(message);
		for ( int row =0 ; row < matrix.length ; row++) {
			System.out.println(Arrays.toString(matrix[row]));
		}
	}
	
	public static void main(String[] args) {
		int [] [] matrix = new int [] [] 
				{ {0,2,3,11}, 
			    {4,5,6,12} ,
			    {7,8,9,0} };
				printMatrix("After transformation" ,matrix);
				setMatrixZeroInPlace(matrix);
				
				printMatrix("After transformation" , matrix);
				
				
	}

}
