package com.javatest.sort;

/**
 * Java program for implementation of Insertion Sort
 * 
 * http://quiz.geeksforgeeks.org/insertion-sort/
 * 
 * 1) Create an empty sorted (or result) list 
 * 2) Traverse the given list, do following for every node. 
 * ......a) Insert current node in sorted way in sorted or result list. 
 * 3) Change head of given linked list to head of sorted (or result) list.
 * 
Time Complexity: O(n*n)
Auxiliary Space: O(1)
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
Algorithmic Paradigm: Incremental Approach
Sorting In Place: Yes
Stable: Yes
Online: Yes
Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, 
only few elements are misplaced in complete big array.
 * 
 */
class InsertionSort
{
    /*Function to sort array using insertion sort*/
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
 
    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {        
        int arr[] = {12, 11, 13, 5, 6};
 
        InsertionSort ob = new InsertionSort();        
        ob.sort(arr);
         
        printArray(arr);
    }
} /* This code is contributed by Rajat Mishra. */