package com.javatest.array;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void printDate(int i) {
        
        String day = "";
        switch(i) {
            case 1: day = "SUNDAY"; break;
            case 2 : day = "MONDAY"; break;
            case 3: day = "TUESDAY"; break;
            case 4 : day = "WEDNESDAY"; break;
            case 5: day = "THURSDAY"; break;
            case 6 : day = "FRIDAY"; break;
            case 7: day = "SATURDAY"; break;
            default : day = "Invalid";
        }
        System.out.println(day);
    }

    public static void main(String[] args) {
    	
    	
    	
        Scanner scan = new Scanner(System.in);
        
        int month = scan.nextInt();
        int day = scan.nextInt();
        int year = scan.nextInt();
        Calendar cal = new GregorianCalendar(year, month, day);
        int dayInt = cal.get(Calendar.DAY_OF_WEEK );
        printDate(dayInt);
    }
}