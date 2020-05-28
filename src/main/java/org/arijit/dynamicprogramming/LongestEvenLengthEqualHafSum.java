package org.arijit.dynamicprogramming;

public class LongestEvenLengthEqualHafSum {
	public static void main(String args[]){
		String str = "1538023";
		calculate(str);
	}
	

	public static void calculate(String str){
		char[] arr = str.toCharArray();
		int dp[][] = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++){
			dp[i][i] = arr[i]-'0';
		}
		int maxLen = -1;
		int start = 0;
		int end = 0;
		for(int l=2;l<=arr.length;l++){ // we need to go till the full length of string.
			for(int i=0;i<arr.length-l+1;i++){
					int j = i+l-1;
					int k = l/2;
					int brk = i+k-1;// breaking between i - j with lenght k
					int sum = dp[i][brk]+dp[brk+1][j];
					dp[i][j] = sum;				
					if(l%2==0 && dp[i][brk]==dp[brk+1][j]){
							//we have found even length with equal sum.
							int len = j-i+1;
							if(len>maxLen){
									maxLen = len;	
									start = i;
									end = j;
							}
					}
			}			
		}
		System.out.println("Longest Substring between index: "+start+"-"+end+" :: "+str.substring(start,end+1));
	}
}
