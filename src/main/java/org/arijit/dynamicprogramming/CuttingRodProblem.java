package org.arijit.dynamicprogramming;

import java.util.Arrays;

public class CuttingRodProblem {
	public static void main(String args[]) {
		int price[]= {1,   5 ,  8 ,  9,  10,  17,  17,  20};
		int length = 8;
		System.out.println(maxValue(price, length));
	}
	
	public static int maxValue(int[] price, int length) {
		int dp[][] = new int[price.length+1][length+1];
		
		for(int i=1;i<dp[0].length;i++) {
			int p = price[0];
			dp[1][i] =  i*p;
		}
		
		for(int i=2;i<dp.length;i++) {
			int priceIndex = i-1; //here i index is ahead of price index as we are starting from 2.
			for(int j=1;j<dp[0].length;j++) {				
				if(i>j) { //cut is more than expected length
					dp[i][j]=dp[i-1][j];
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], (dp[i][j-i]+price[priceIndex]));
				}				
			}
			printArray(dp);
		}
		return dp[dp.length-1][dp[0].length-1];
	}

	
	private static void printArray(int[][] dp) {
		for(int i=0;i<dp.length;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}

}
