package org.arijit.dynamicprogramming;

import java.util.Arrays;

public class SubsetSum {

	public static void main(String args[]) {
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum=22;
		System.out.println(isSubSetSum(set, sum));
	}
	public static boolean isSubSetSum(int[] arr, int sum){
		boolean dp[][] = new boolean[arr.length+1][sum+1];
		for(int i=0;i<dp.length;i++)
			dp[i][0]=true;
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){				
				if(arr[i-1]>j)
					dp[i][j]=dp[i-1][j];
				else{
						dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
					}
//				printArray(dp);
			}
		}
		trackNumber(dp, arr);
		return dp[dp.length-1][dp[0].length-1];
	}
	
	public static void printArray(boolean dp[][]) {
		for(int i=0;i<dp.length;i++)
			System.out.println(Arrays.toString(dp[i]));
	}
	
	private static void trackNumber(boolean[][] dp,int input[]) {
		int i=dp.length-1;
		int j=dp[0].length-1;
		if(!dp[i][j])
			return; //no subset sum found
		while(i>=0 && j>=0) {
		while(i>=0 && dp[i][j]) {
			i--;			
		}
		if(i>=0)
		{
			System.out.println(input[i]);
			j= j-input[i];
		}
		}
	}

}
