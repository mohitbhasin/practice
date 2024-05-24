class CountIsland {
	public static void main(String args[]) {
		int[][] matrix = {
			{1,1,0,0,0},
			{1,1,0,0,0},
			{0,0,1,0,0},
			{1,0,0,1,1}};
		System.out.println(count(matrix));
	}

	static boolean[][] visited;
//Wrong - only going digonally
	public static int count(int[][] matrix) {
		int i=0;
		int j=0;
		int count=0;
		visited = new boolean[matrix.length][matrix[0].length];
		while(i<matrix.length && j<matrix[0].length) {
			if(matrix[i][j]==1 && !visited[i][j]) {
				markVisited(i, j, matrix);
				count++;
			}
			i++;
			j++;
		}

		return count;
	}

	public static void markVisited(int i, int j, int[][] matrix) {
		if(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length && !visited[i][j] && matrix[i][j]==1) {
			visited[i][j]=true;
			markVisited(i+1, j, matrix);
			markVisited(i, j+1, matrix);
			markVisited(i-1, j, matrix);
			markVisited(i, j-1, matrix);
		}

	}
}