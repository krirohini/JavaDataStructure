package com.ideserve.array;
class FindDuplicate
{
	void printRepeating(int arr[], int size)
	{
		System.out.println("The repeating elements are : ");
	
		for (int i = 0; i < size; i++)
		{
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}		 
	} 
	
	void printRepeatingSumAndProduct(int arr[], int size) 
    {
        /* S is for sum of elements in arr[] */
        int S = 0;
         
        /* P is for product of elements in arr[] */
        int P = 1;
         
        /* x and y are two repeating elements */
        int x, y;
         
        /* D is for difference of x and y, i.e., x-y*/
        int D;
         
        int n = size - 2, i;
 
        /* Calculate Sum and Product of all elements in arr[] */
        for (i = 0; i < size; i++) 
        {
            S = S + arr[i];
            P = P * arr[i];
        }
 
        /* S is x + y now */
        S = S - n * (n + 1) / 2;
         
        /* P is x*y now */
        P = P / fact(n);
        
        /* D is x - y now */
        D = (int) Math.sqrt(S * S - 4 * P);
         
 
        x = (D + S) / 2;
        y = (S - D) / 2;
 
        System.out.println("The two repeating elements are :");
        System.out.print(x + " " + y);
    }
 
    int fact(int n) 
    {
        return (n == 0) ? 1 : n * fact(n - 1);
    }
    
    void printRepeatingBuffer(int arr[], int size) 
    {
        int count[] = new int[size];
        int i;
 
        System.out.println("Repeated elements are : ");
        for (i = 0; i < size; i++) 
        {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else
                count[arr[i]]++;
        }
    }

	/* Driver program to test the above function */
	public static void main(String[] args) 
	{
		FindDuplicate duplicate = new FindDuplicate();
		int arr[] = {4, 2, 4, 2, 5, 6, 1};
		int arr_size = arr.length;
		duplicate.printRepeating(arr, arr_size);
	}
}

