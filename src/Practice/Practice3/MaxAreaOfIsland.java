class MaxAreaOfIsland {
	public static void main(String args[]) {
		int[][] grid = {
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0}
		};
		System.out.println(maxArea(grid));
	}

	public static int maxArea(int[][] grid) {
		int result=0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j]==1) {
					result = Math.max(result, dfs(grid, i, j));
				}
			}	
		}
		return result;
	}

	public static int dfs(int[][] grid, int i, int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) {
			return 0;
		}
		grid[i][j]=0;
		return 1 + dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1);
	}

}