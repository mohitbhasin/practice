import java.util.*;

// This is similar to MaximalSquare question. 
// Instead of char[][], it has int[][] as given input.
class MaximumGoodLandArea {
	public static void main(String args[]) {
		List<int[][]> matList = new ArrayList<>();
		matList.add(new int[][]{
			{1,1,1,0,1},
			{1,1,0,1,0},
			{0,1,1,1,0},
			{1,1,1,1,0},
			{1,1,1,1,1},
			{0,0,0,0,0}

		});
		for(int i=0; i<matList.size(); i++){
			System.out.println(findArea(matList.get(i)));
		}
	}

	public static int findArea(int[][] mat) {
		int[][] dp = new int[mat.length][mat[0].length];
		int maxArea = 0;
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j]==1){
					if(i==0 || j==0) {
						dp[i][j]=1; // Base case of setting first row and column.
					} 
					else {
						int min = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
						dp[i][j]=min+1;
						maxArea = Math.max(maxArea, dp[i][j]*dp[i][j]);
					}
				}
			}
		}
		return maxArea;
	}
}