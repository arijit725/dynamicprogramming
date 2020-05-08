package org.arijit.dynamicprogramming;

public class UnboundedKnapsackProblem {
	public static void main(String args[]) {
		int W = 100;
		int val[] = {1, 30};
		int wt[] ={1, 50};
		System.out.println(knapsack(val, wt, W));
	}

public static int knapsack(int val[], int wt[], int maxWt){
			if(val==null || val.length==0)
					return 0;
			if(wt == null || wt.length==0)
				return 0;
			int dp[][] = new int[val.length][maxWt+1];
			for(int i=1;i<dp[0].length;i++){	
				if(i%wt[0]==0)
					dp[0][i]=(i/wt[0])*val[0];
			}
			for(int i=1;i<dp.length;i++){
				for(int j=1;j<dp[0].length;j++){
					if(wt[i]>j)
						dp[i][j]=  dp[i-1][j];
				else{
						dp[i][j] = Math.max(dp[i-1][j],(val[i]+dp[i][j-wt[i]]));
					}
				}
			}
		return dp[dp.length-1][dp[0].length-1];
}

}
