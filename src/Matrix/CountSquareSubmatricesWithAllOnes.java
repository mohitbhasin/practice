import java.util.*;

class CountSquareSubmatricesWithAllOnes {
	public static void main(String args[]) {
		List<int[][]> list = new ArrayList<>();
		list.add(new int[][] {{0,1,1,1},{1,1,1,1},{0,1,1,1}});
		list.add(new int[][] {{1,0,1},{1,1,0},{1,1,0}});
		for(int[][] matrix: list) {
			System.out.println(countSquares(matrix));
			// System.out.println(countSquares_additionSpace(matrix));
		}
	}

	public static int countSquares(int[][] matrix) {
		int total = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j]==1) {
					int min = Integer.MAX_VALUE;
					if(j-1>=0 && i-1>=0) {
						min = Math.min(min, matrix[i][j-1]);
						min = Math.min(min, matrix[i-1][j-1]);
						min = Math.min(min, matrix[i-1][j]);
					} else {
						min=0;
					}
					matrix[i][j]=min+1;
					total += matrix[i][j];
				}
			}
		}
		return total;
	}

	public static int countSquares_additionSpace(int[][] matrix) {
		int[][] dp = new int[matrix.length+1][matrix[0].length+1];
		int total = 0;
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(matrix[i-1][j-1]==1) {
					dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]))+1;
					total+=dp[i][j];
				}
			}
		}
		return total;
	}
}