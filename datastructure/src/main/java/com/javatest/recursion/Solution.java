package com.javatest.recursion;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long countWays( int n) {
        long [] ways = new long [n+1]; 
        return countWays( n , ways);
    }

    public static long countWays( int n, long [] ways) {
        if(n < 0) 
            return 0;
        if( n == 0  )
            return 1; 
       
        if(ways[n] > 0) 
            return ways[n];
        
        //int total = 0;
        
        ways[n] = countWays(n-1, ways) +
            countWays(n-2, ways) + 
            countWays(n-3, ways) ;
        return ways[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
        }
        
        for(int a0 = 0; a0 < s; a0++){
            System.out.println(countWays(a0));
        }
        
    }
}