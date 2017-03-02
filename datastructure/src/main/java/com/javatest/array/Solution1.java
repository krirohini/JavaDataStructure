package com.javatest.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {
    
	 static int numberOfPairs(int[] a, long k) {
		 
		 Set set = new HashSet();
		 StringBuffer buffer = new StringBuffer();
	
	       Arrays.sort(a);
	        
	        int start =0; 
	        int end = a.length -1; 
	        int noOfPairs = 0;
	        while(start < end) {
	            
	            int tempSum = a[start] + a[end];
	            if (tempSum  == k) {
	                
	                noOfPairs++;
	                //Skip Duplicates for start
	                while( (start+1 < a.length) && a[start] == a[start+1] ) { 
	                    start++;
	                }
	                //Skip Duplicates for end
	                while((end -1 >= 0 ) && (a[end] == a[end-1] )) { 
	                    end-- ;
	                }
	                      start++;
	                      end--;
	                
	            }  else if (tempSum < k) {
	                start++;
	            } else {
	                end--;
	            }
	            
	        }
	        
	        return noOfPairs;

	    }


   static boolean isBalanced(String str) {
          if(str == null || str.length() ==0) {
                return false;
           }
           Stack<Character> stack = new Stack<> ();
           for( int i = 0; i < str.length() ; i++) { 
               char ch = str.charAt(i);
              if( ch ==  '{' || ch == '[' || ch == '(') {
                  stack.push(ch);
              } else if (!stack.isEmpty()) {
                  
                  char top = stack.pop();
                  if(! (
                      (top == '{' && ch == '}') || 
                      (top == '[' && ch == ']') ||
                      (top == '(' && ch == ')')
                      ) ) {
                     return false; 
                 }     
              } else {
                  return false;
              }
          }
         if(!stack.isEmpty()) {
             return false;
         }
         return true;
     }

    static String[] braces(String[] values) {
       if(null == values || values.length == 0 ) { 
           return null;
       }
        String [] result = new String[values.length];
        for(int i = 0  ; i < values.length ; i++)  {
           if(isBalanced(values[i])) {
               result[i] = "YES";
           } else{
               result[i] = "NO";
           }
        }
        return result;
    }
 public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        
        int _values_size = 0;
        _values_size = Integer.parseInt(in.nextLine().trim());
        String[] _values = new String[_values_size];
        String _values_item;
        for(int _values_i = 0; _values_i < _values_size; _values_i++) {
            try {
                _values_item = in.nextLine();
            } catch (Exception e) {
                _values_item = null;
            }
            _values[_values_i] = _values_item;
        }
        
        res = braces(_values);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }
}
