package com.java.test.designPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * * This is our adaptee, a third party implementation of a * number sorter
 * that deals with Lists, not arrays.
 */
class NumberSorter {
	public List<Integer> sort(List<Integer> numbers) {
		// sort and return
		//return new ArrayList<Integer>();
		return  numbers.sort(null);
	}
}
	
	
//this is our Target interface
 interface Sorter{
	public int[] sort(int[] numbers);
}
 
public class SortListAdapter implements Sorter {
	@Override
	public int[] sort(int[] numbers) {
		// convert the array to a List
		List<Integer> numberList = new ArrayList<Integer>();
		// call the adapter
		NumberSorter sorter = new NumberSorter();
		numberList = sorter.sort(numberList);
		// convert the list back to an array and return
		return numberList.toArray();
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[]{34, 2, 4, 12, 1};           
		Sorter sorter = new SortListAdapter();      
		sorter.sort(numbers);
	}
}

