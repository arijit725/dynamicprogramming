package org.arijit.dynamicprogramming;

public class EggsDroppingProblem {
	
	public static void main(String args[]) {
		int floor = 36;
		int eggs=2;
		eggsDropTry(floor, eggs);
	}

	public static void eggsDropTry(int floor, int eggCount) {
		int T[][] = new int[eggCount + 1][floor + 1];
		for (int i = 1; i < floor; i++) {
			// when you have only one egg, try count will be equal to floor count
			T[1][i] = i;
		}
		for (int i = 2; i <= eggCount; i++) {
			for (int j = 1; j <= floor; j++) {
				if (i > j) {
					T[i][j] = T[i - 1][j];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = 1; k <= j; k++) {
						// figure out max attempt between if eggs break and remaining floor vs if eggs
						// does not break and remaining floor
						int l = Math.max(T[i - 1][k - 1], T[i][j - k]);
						if (l < min)
							min = l;
					}
					T[i][j] = 1 + min;
				}
			}
		}
		System.out.println("Try Count: " + T[eggCount][floor]);
	}

}
