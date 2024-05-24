class NumberOfIslands {
	public static void main(String args[]) {
		int[][] matrix = {
			{1,1,0,0,0},
			{1,1,0,0,0},
			{0,0,1,0,0},
			{0,0,0,1,1}
		};
		System.out.println(countIslands(matrix));
	}

	public static int countIslands(int[][] matrix) {
		int numIslands = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j]==1) {
					numIslands++;
					markVisisted(matrix, i, j);
				}
			}
		}
		return numIslands;
	}

	public static void markVisisted(int[][] matrix, int i, int j) {
		if(i<matrix.length && i>=0 && j<matrix[0].length && j>=0 && matrix[i][j]==1) {
			matrix[i][j]=0;
			markVisisted(matrix, i+1, j);
			markVisisted(matrix, i-1, j);
			markVisisted(matrix, i, j+1);
			markVisisted(matrix, i, j-1);
		}
	}
}