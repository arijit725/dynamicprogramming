package org.arijit.dynamicprogramming;

import java.util.Arrays;

public class MaximumLengthChainPair {

	public static void main(String args[]) {
		int[][] chain =  {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} };
		longestChain(chain);
	}
	
	private static void longestChain(int[][] chain) {
		int[] lengthTracker = new int[chain.length];
		int[] tracker = new int[chain.length];
		for(int i=0;i<chain.length;i++) {
			lengthTracker[i]=1; //one element makes chain of length 1.
			tracker[i]=-1;
		}
		int maxLengthSoFar = Integer.MIN_VALUE;
		int posSoFar = 0;
		for(int i=1;i<chain.length;i++) {
			for(int j=0;j<i;j++) {
				if(chain[j][1]<chain[i][0] && lengthTracker[i]<(lengthTracker[j]+1)) {
					lengthTracker[i] = lengthTracker[j]+1;
					tracker[i] = j;
					if(maxLengthSoFar<lengthTracker[i]) {
						maxLengthSoFar = lengthTracker[i];
						posSoFar = i;
					}
				}
			}
		}
		System.out.println(maxLengthSoFar);
		System.out.println(Arrays.toString(tracker));
		int i=posSoFar;
		while(i>=0) {
			System.out.println(Arrays.toString(chain[i]));
			i = tracker[i];			
		}
	}
}
