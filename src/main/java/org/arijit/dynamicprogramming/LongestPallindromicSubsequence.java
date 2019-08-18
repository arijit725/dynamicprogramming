package org.arijit.dynamicprogramming;

public class LongestPallindromicSubsequence {

	private void longesPallindromicSubsequence(String str) {
		int dp[][] = new int[str.length()][str.length()];
		// when charecter length is 1 we can have maximum length of pallndromic
		// subsequence is 1.
		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = 1;
		}

		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2 && str.charAt(i) == str.charAt(j)) {
					dp[i][j] = 2;
				} else if (str.charAt(i) == str.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		System.out.println("Longest Pallindromic Sequence:" + dp[0][str.length() - 1]);
	}

	public static void main(String args[]) {
		String str = "agbdba";
		LongestPallindromicSubsequence subsequence = new LongestPallindromicSubsequence();
		subsequence.longesPallindromicSubsequence(str);
	}

}
