package com.javatest.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindFirstUniqueElement {
	
	public static Integer findFirstUniqueElementUsingHashMap(Integer [] input) {
		Map<Integer, Integer> counterMap = new HashMap<>();
		for ( Integer i : input) { 
			if(counterMap.containsKey(i)) {
				
				Integer count = counterMap.get(i) + 1;
				counterMap.put(i, count);
				
			} else {
				counterMap.put(i, Integer.valueOf(1));
			}
		}
		
		for ( Integer i : input) { 
			if(counterMap.containsKey(i) && counterMap.get(i) == 1 ) {
				return i;
			}
		}
		
		return Integer.MIN_VALUE;
	}
	
	public static Integer findFirstUniqueElement(Integer [] input) {
		
		Set<Integer> uniqueSet = new HashSet<>();
		List<Integer> uniqueList = new ArrayList<>();
		
		for ( Integer i : input) { 
			if(uniqueSet.contains(i)) {
				// remove from unique list
				uniqueList.remove(i);
			} else {
				// add in Set and List
				uniqueSet.add(i);
				uniqueList.add(i);
			}
		}

		System.out.println(uniqueList);
		if(uniqueList.size() > 0) {
			return uniqueList.get(0);
		}
		
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		//Integer [] input = new Integer[] { 1,2,2,1,1,3,1,4,4,3,5,6};
		Integer [] input = new Integer[] { 1,2,2,1,2,1,2,3,1,4,4,3,5,6};
		
		Integer firstUniqueElement = findFirstUniqueElement(input);
		System.out.println("firstUniqueElement is " + firstUniqueElement);
		System.out.println("firstUniqueElement using Map is " + findFirstUniqueElementUsingHashMap(input));
		
	}

}
