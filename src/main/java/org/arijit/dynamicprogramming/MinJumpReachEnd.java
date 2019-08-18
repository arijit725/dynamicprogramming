package org.arijit.dynamicprogramming;

import java.util.Arrays;

public class MinJumpReachEnd {
	private void minJump(int arr[], int index[]) {
		int[] ref = new int[arr.length];
		ref[0] = 0;
		for (int i = 1; i < ref.length; i++) {
			ref[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((arr[j] + j) >= i) {
					if (ref[i] > (1 + ref[j])) {
						ref[i] = 1 + ref[j];
						index[i] = j;
					}
				}
			}
		}
		System.out.println("Minimum Jump Needs to reach end: " + ref[ref.length - 1]);
		int i = index.length - 1;
		int j = i;
		do {
			j = i;
			System.out.print(arr[i] + " ");
			i = index[i];
		} while (j != 0);
	}

	public static void main(String args[]) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int index[] = new int[arr.length];
		MinJumpReachEnd minJumpReachEnd = new MinJumpReachEnd();
		minJumpReachEnd.minJump(arr, index);
	}

}
