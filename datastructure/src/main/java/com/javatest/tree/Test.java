package com.javatest.tree;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {

public static void main(String[] args) {
//	 Scanner in = new Scanner(System.in);
//         int a = in.nextInt();
//         int b = in.nextInt();
//         int n = in.nextInt();
//     in.close();
	//printSeries(0, 2, 10);
	int n = 9876;
	while (n > 0) { 
	System.out.print(n%10);
	n = n/10;
	} 
	String s = "hello";
	char c = 'c';
	s.substring(0, 1).toUpperCase();
	StringBuffer buf = new StringBuffer();
	buf.toString();
	
	 Calendar calendar = new GregorianCalendar(2017, 2, 23);
	 int i = calendar.get(Calendar.DAY_OF_WEEK);
	 System.out.println("\n" + i);
}

public static void printSeries(int a, int b , int n) {
	int sum = a; 
	for( int i = 0 ; i < n ; ++i) {
		sum = (int) (sum + (Math.pow(2, i)*b));
		System.out.print( sum + " ");
		
		
	}
}
}
