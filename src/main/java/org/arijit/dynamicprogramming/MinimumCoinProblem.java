package org.arijit.dynamicprogramming;

public class MinimumCoinProblem {

	public static void main(String args[]) {
		int coin[]= {1,5,6,9};
//		int coin[] = { 5, 10, 25 };
		int total = 30;
		minimumCoinNeeds(coin, total);
	}

	public static void minimumCoinNeeds(int[] coin, int total) {
		int T[][] = new int[coin.length][total + 1];
		// we can not get total 0 with any coin. so first column is 0 always.
		for (int i = 1; i <= total; i++) {
			int k = coin[0];
			if (i < k) {
				// we can not build this total with only this coin
				T[0][total] = 0;
			} else {
				if (i % k == 0)
					T[0][i] = i / k;
				else
					T[0][i] = 0;
			}
		}
		for (int i = 1; i < coin.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (coin[i] > j)
					T[i][j] = T[i - 1][j];
				else {
					T[i][j] = Math.min(T[i - 1][j], (1 + T[i][j - coin[i]]));
				}
			}
		}
		System.out.println("Total coin: " + T[T.length - 1][T[0].length - 1]);
		traceCoin(T, coin);
	}

	public static void traceCoin(int[][] T, int[] coin) {
		int i = T.length - 1;
		int j = T[0].length - 1;
		while (i >= 0 && j >= 0) {
			if(i==0) {
				System.out.println(coin[i]);
				i--;
			}
			else if (T[i][j] == T[i - 1][j])
				i--;
			else {
				System.out.println(coin[i]);
				j = j - coin[i];
				if(j==0)
					// we have reached 0th column, so no need to further tracing.
					break;
			}
		}

	}
}
