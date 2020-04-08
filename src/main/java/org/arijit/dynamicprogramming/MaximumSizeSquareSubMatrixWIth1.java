package org.arijit.dynamicprogramming;

public class MaximumSizeSquareSubMatrixWIth1 {

	public static void main(String args[]){
		int arr[][]={
				{0,1,1,0,1},
				{1,1,0,1,0},
				{0,1,1,1,0},
				{1,1,1,1,0},
				{1,1,1,1,1},
				{0,0,0,0,0}
			    };

		calculate(arr);
	}


	private static void calculate(int[][] arr){
		int t[][] = new int[arr.length][arr[0].length];
		for(int i=0; i<arr[0].length;i++){
		  t[0][i]=arr[0][i];
		}		
		for(int i=0;i<arr.length;i++){
		  t[i][0]=arr[i][0];
		}
		int maxSize=-1;
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<arr[0].length;j++){
				if(arr[i][j]==0)	
					t[i][j]=0;
				else{
					t[i][j]=1+min(t[i-1][j],t[i-1][j-1],t[i][j-1]);
					}	
				if(t[i][j]>maxSize)
				   maxSize = t[i][j];
			}
		}
		
	System.out.println("Max subsqaure with 1= "+maxSize);
	}
	
	private static int min(int x, int y, int z) {
		int tmp = Math.min(x, y);
		tmp = Math.min(tmp, z);
		return tmp;
	}
}
