package FibonacciSteps;

import java.util.Scanner;

import com.javatest.recursion.fibonacci;

/**
 * URL: http://www.careercup.com/question?id=3590768
 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * Problem Description:
 * Given n stairs, how many number of ways can you climb if u use either 1 or 2
 * at a time?
 *
 */
public class FibonacciSteps {
	
	Integer n;			// number of steps
	Integer mem[];	// memorization array where [i] holds answer for i steps left
	
	
	
	public FibonacciSteps(int steps) {
	      n = steps;
		mem = new Integer[steps+1];
		mem[0] =1;
	}

	private Integer solve( Integer stepLeft ) {
		if(mem[stepLeft] != null) return mem[stepLeft];
		
		Integer ways = 0; 
		
		if(stepLeft >=  2) ways += solve(stepLeft-2);
		if(stepLeft >=  1) ways += solve(stepLeft-1);
		mem[stepLeft] = ways;
		return ways;
	}

	private void run() {
		System.out.println(solve(n));
		System.out.println("From DP " + countWays(n));
		
	}
	
	// Returns number of ways to reach s'th stair
    static int countWays(Integer s)
    {
        return fibonacci.fibonacciDP(s + 1);
    }
 
    // http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
    int countWaysUtil(int numberOfSteps, int skipSteps)
    {
        int[] res = new int[numberOfSteps];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<numberOfSteps; i++)
        {
           res[i] = 0;
           for (int j=1; j<=skipSteps && j<=i; j++)
             res[i] += res[i-j];
        }
        return res[numberOfSteps-1];
    }
     
    // Returns number of ways to reach s'th stair
    int countWays(int s, int m)
    {
        return countWaysUtil(s+1, m);
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FibonacciSteps steps = new FibonacciSteps(sc.nextInt());
		steps.run();
		
		
		sc.close();
	}



	

}
