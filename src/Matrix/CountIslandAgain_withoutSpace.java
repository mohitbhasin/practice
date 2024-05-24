class CountIslandAgain_withoutSpace {
	public static void main(String args[]) {
		int[][] matrix = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        System.out.println(count(matrix));
	}

	public static int count(int[][] mat) {
		int count=0;
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j]==1) {
					count++;
					mark(mat, i, j);
				}
			}	
		}
		return count;
	}

	public static void mark(int[][] mat, int i, int j) {
		if(i>=0 && i<mat.length && j>=0 && j<mat[0].length && mat[i][j]==1) {
			mat[i][j]=0;
			mark(mat, i+1, j);
			mark(mat, i-1, j);
			mark(mat, i, j+1);
			mark(mat, i, j-1);
		}
	}
}