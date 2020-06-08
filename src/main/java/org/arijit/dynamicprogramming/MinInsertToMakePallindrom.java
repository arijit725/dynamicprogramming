package org.arijit.dynamicprogramming;

/**
 * <pre>
 * Given a string str, the task is to find the minimum number of characters to be inserted to convert it to palindrome.
Before we go further, let us understand with few examples:

ab: Number of insertions required is 1 i.e. bab
aa: Number of insertions required is 0 i.e. aa
abcd: Number of insertions required is 3 i.e. dcbabcd
abcde: Number of insertions required is 4 i.e. edcbabcde
 * </pre>
 * 
 * @author arijit
 *
 */
public class MinInsertToMakePallindrom {

	public static void main(String args[]) {
		String str = "abcda";
		minInsert(str);
	}

	public static void minInsert(String str) {
		String strRev = reverseString(str);
		int l = lcs(str.toCharArray(), strRev.toCharArray());
		int ls = str.length() - l;
		System.out.println("Minimum Insertion: " + ls);
	}

	public static String reverseString(String str) {
		if (str == null)
			return null;
		String strRev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			strRev = strRev + str.charAt(i);
		}
		return strRev;
	}

	public static int lcs(char[] str1, char[] str2) {
		int dp[][] = new int[str1.length + 1][str2.length + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (str1[i - 1] == str2[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
