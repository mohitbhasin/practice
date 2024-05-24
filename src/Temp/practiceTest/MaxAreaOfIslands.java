class MaxAreaOfIslands {
	public static void main(String args[]) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,1,1,0,1,0,0,0,0,0,0,0,0},
						{0,1,0,0,1,1,0,0,1,0,1,0,0},
						{0,1,0,0,1,1,0,0,1,1,1,0,0},
						{0,0,0,0,0,0,0,0,0,0,1,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,0,0,0,0,0,0,1,1,0,0,0,0}};

		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                if(grid[i][j]==1) {
                    maxArea = Math.max(maxArea, getArea(grid, i, j));
                }
            }   
        }
        return maxArea;
    }
    
    public static int getArea(int[][] grid, int i, int j) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]==1) {
            grid[i][j]=0;
            System.out.println(i+", "+j);
            return 1 + getArea(grid, i+1, j) + getArea(grid, i, j+1) + getArea(grid, i-1, j) + getArea(grid, i, j - 1);
        }
        return 0;
    }
}