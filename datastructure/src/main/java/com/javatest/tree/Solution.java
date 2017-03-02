package com.javatest.tree;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan  = new Scanner(System.in);
//        String str = scan.nextLine();
//        int len = scan.nextInt();
        
//        String min = str.substring(0, len);
//        String max = str.substring(0, len);
//        min.charAt(index)
//        for(int i = 0; i <= str.length() - len  ; i++) {
//            String tmp = str.substring(i, i+len);
//            if(tmp.compareTo(min) < 0) {
//                min = tmp;
//            }
//            if(tmp.compareTo(max) > 0) {
//                max = tmp;
//            }
//        }
//        
//        System.out.println(min);
//        System.out.println(max);
        
        String A=scan.next();
        int start =0;
        int end = A.length() -1;
        boolean isPeln = true;
      
//        
//        while(start <= end) {
//            if(A.charAt[start] != A.charAt[end]) {
//                isPeln = false;
//                break;
//            }
//            start++;
//            end--;
//        }
//        
        System.out.println(isPeln ? "Yes" : "No");
    }
}