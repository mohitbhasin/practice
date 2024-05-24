class NumberOfIslands {
	public static void main(String args[]) {
		char[][] grid = new char[][]{
		  	{'1','1','0','0','0'},
		  	{'1','1','0','0','0'},
		  	{'0','0','1','0','0'},
	  		{'0','0','0','1','1'}
		};

		System.out.println(countIslands(grid));
	}

	public static int countIslands(char[][] grid) {
		int result=0;

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid.length; j++) {
				if(grid[i][j]=='1') {
					result+=dfs(grid, i, j);
				}
			}
		}
		return result;
	}

	public static int dfs(char[][] grid, int i, int j) {
		if(i<0 || i>=grid.length || j>=grid[i].length || j<0 || grid[i][j]=='0') {
			return 0;
		}

		grid[i][j]='0';
		dfs(grid, i+1, j);
		dfs(grid, i-1, j);
		dfs(grid, i, j+1);
		dfs(grid, i, j-1);
		return 1;
	}
}