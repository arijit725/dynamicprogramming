package org.arijit.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	public static void main(String args[]) {
		String words[] = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", 
			  "cream", "icecream", "man", "go", "mango"};
		HashSet<String> set = new HashSet<String>(Arrays.asList(words));
		String str = "i like sam sung";
		boolean b = breakWord(set, str);
		System.out.println(b);
		
	}
	public static boolean breakWord(Set<String> words, String line){
		char[] str = line.toCharArray();
		boolean dp[][] = new boolean[str.length][str.length];
		for(int i=0;i<dp.length;i++){
				if(words.contains(""+str[i])|| str[i]==' '){
					dp[i][i]=true;
			}
		}
		for(int l=2;l<=dp.length;l++){
			for(int i=0;i<dp.length-l+1;i++){
				int j= i+l-1;
				String sub= line.substring(i,j+1);				
				if(words.contains(sub))
					dp[i][j]=true;
				else{
					for(int k=1;k<=j;k++){
							if(dp[i][k-1]&&dp[k][j]){
								dp[i][j]=true;
								break;	
							}
						}
					
				}
			
			}
		}		
		return dp[0][dp[0].length-1];
	}
	
	public static void printArray(boolean dp[][]) {
		for(int i=0;i<dp.length;i++)
			System.out.println(Arrays.toString(dp[i]));
	}
}
