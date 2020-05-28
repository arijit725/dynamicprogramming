package org.arijit.dynamicprogramming;

/**
 * <pre>
 * Maximum value with the choice of either dividing or considering as it is
We are given a number n, we need to find the maximum sum possible with the help of following function:
F(n) = max( (F(n/2) + F(n/3) + F(n/4) + F(n/5)), n). To calculate F(n, ) we may either have n as our result or we can 
further break n into four part as in given function definition. 
This can be done as much time as we can. 
Find the maximum possible sum you can get from a given N. Note : 1 can not be break further so F(1) = 1 as a base case.

Examples :

Input : n = 10
Output : MaxSum = 12
Explanation: 
f(10) = f(10/2) + f(10/3) + f(10/4) + f(10/5)
      = f(5)  +   f(3)  +  f(2)   +  f(2)
      = 12
5, 3 and 2 cannot be further divided.

Input : n = 2
Output : MaxSum = 2
 * </pre>
 * 
 * @author arijit
 *
 */
public class MaximumValueOfChoice {

	public static void main(String args[]) {

		int n = 60;
		System.out.println("Sum: " + sumOfChoice(n));
	}

	public static int sumOfChoice(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.max(i, (dp[i / 2] + dp[i / 3] + dp[i / 4] + dp[i / 5]));
		}
		return dp[n];
	}
}
