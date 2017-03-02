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

*Binary Insertion Sort
We can use binary search to reduce the number of comparisons in normal insertion sort. Binary Insertion Sort find use binary search to find the proper location to insert the selected item at each iteration. 
In normal insertion, sort it takes O(i) (at ith iteration) in worst case. we can reduce it to O(logi) by using binary search.
 * http://quiz.geeksforgeeks.org/binary-insertion-sort/
 */
class BinaryInsertionSort
{
	// A binary search based function to find the position
	// where item should be inserted in a[low..high]
	int binarySearch(int a[], int item, int low, int high)
	{
		//special condition 
	    if (high <= low)
	        return (item > a[low])?  (low + 1): low;
	 
	    int mid = (low + high)/2;
	 
	    if(item == a[mid])
	        return mid+1;
	 
	    if(item > a[mid])
	        return binarySearch(a, item, mid+1, high);
	    return binarySearch(a, item, low, mid-1);
	}
	
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
         // find location where selected sould be inseretd
            int loc = binarySearch(arr, key, 0, j);
            //optimization 
            // In normal insertion, sort it takes O(i) (at ith iteration)
            // in worst case. we can reduce it to O(logi) by using binary search.
            // Time Complexity: The algorithm as a whole still has a running worst case 
            // running time of O(n2) because of the series of swaps required for each insertion.
            //while (j>=0 && arr[j] > key)
            while (j >= loc)
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
 
        BinaryInsertionSort ob = new BinaryInsertionSort();        
        ob.sort(arr);
         
        printArray(arr);
    }
} /* This code is contributed by Rajat Mishra. */