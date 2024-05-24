class NumberofClosedIslands {
	static boolean[][] visited;
	public static void main(String args[]) {
		int[][] grid = {{0,0,1,1,0,1,0,0,1,0},
						{1,1,0,1,1,0,1,1,1,0},
						{1,0,1,1,1,0,0,1,1,0},
						{0,1,1,0,0,0,0,1,0,1},
						{0,0,0,0,0,0,1,1,1,0},
						{0,1,0,1,0,1,0,1,1,1},
						{1,0,1,0,1,1,0,0,0,1},
						{1,1,1,1,1,1,0,0,0,0},
						{1,1,1,0,0,1,0,1,0,1},
						{1,1,1,0,1,1,0,1,1,0}};

		// int[][] grid = {{1,1,1,1,1,1,1,0},
		// 				{1,0,0,0,0,1,1,0},
		// 				{1,0,1,0,1,1,1,0},
		// 				{1,0,0,0,0,1,0,1},
		// 				{1,1,1,1,1,1,1,0}};
		visited = new boolean[grid.length][grid[0].length];

		System.out.println(closedIsland(grid));

	}
	public static int closedIsland(int[][] grid) {
        int count = 0;
        for(int i=1; i<grid.length-1; i++) {
            for(int j=1; j<grid[0].length-1; j++) {
                if(grid[i][j]==0 && checkSurroundings(grid, i, j)) {
                	System.out.println(i+", "+j);
                    count++;
                }
            }   
        }
        return count;
    }
    
    public static boolean checkSurroundings(int[][] grid, int i, int j) {
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1) {
            return false;
        }
        if(grid[i][j]!=0) {
            return true;
        }
        grid[i][j]=1;
        visited[i][j]=true;
        return checkSurroundings(grid, i+1, j) && checkSurroundings(grid, i-1, j) && checkSurroundings(grid, i, j+1) && checkSurroundings(grid, i, j-1);
    }
}