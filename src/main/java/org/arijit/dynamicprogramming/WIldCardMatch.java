package org.arijit.dynamicprogramming;

public class WIldCardMatch {

	public static void main(String args[]) {
		String str = "baaabab";
		String pattern = "a*ab";
		System.out.println(wildCardMatch(str, pattern));
	}
	
	public static boolean wildCardMatch(String str, String pattern) {
		boolean dp[][] = new boolean[str.length()+1][pattern.length()+1];
		dp[0][0]=true;//empty set always true
		
		for(int i=1;i<=str.length();i++) {
			for(int j=1;j<=pattern.length();j++) {				
			 if(str.charAt(i-1)==pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
					dp[i][j]=dp[i-1][j-1];
				}
				else if(pattern.charAt(j-1)=='*') {
					dp[i][j]=dp[i-1][j]||dp[i][j-1];
				}
				else 
					dp[i][j]=false;
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
