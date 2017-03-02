package com.ideserve.array;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void arrayReverse( int[] a , int s, int e) {
//        if(s >= e) { 
//            return;
//        }
        e--;
        
        while( s <= e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++; e--;
        }
    }
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        arrayReverse(a, 0, k);
        arrayReverse(a ,k, n);
        arrayReverse(a, 0 , n);
        return a;
    }
    
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int a[] = new int[n];
//        for(int a_i=0; a_i < n; a_i++){
//            a[a_i] = in.nextInt();
//        }
      
    	int n = 20; 
    	int k = 10;
    	int [] a  = new int [] {41, 73, 89, 7, 10 ,1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58 ,26 ,10, 86, 51};
    //    int[] output = new int[n];
    	int[] output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}