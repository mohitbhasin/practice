class MaxArea {
	public static void main(String args[]) {
		int[][] matrix = {	{1,0,0,0,0,0},
							{1,0,0,0,0,0},
							{0,0,1,1,0,0},
							{0,1,1,1,0,0},
							{0,0,1,1,0,0},
							{0,1,1,1,1,0}
						};
		System.out.println(maxArea(matrix));
	}

	static boolean[][] visited;
	public static int maxArea(int[][] matrix) {
		visited = new boolean[matrix.length][matrix[0].length];
		int maxArea=Integer.MAX_VALUE;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j]==1 && !visited[i][j]) {
					maxArea=Math.min(maxArea, dfs(matrix, i, j));
				}
			}			
		}
		return maxArea;
	}

	public static int dfs(int[][] matrix, int i, int j) {
		if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j] || matrix[i][j]==0) {
			return 0;
		}
		visited[i][j]=true;
		return 1 + dfs(matrix, i+1, j) + dfs(matrix, i-1, j) + dfs(matrix, i, j+1) + dfs(matrix, i, j-1);
	}
}