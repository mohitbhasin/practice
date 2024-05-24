class PrintSpiral {
	public static void main(String args[]) {
		int[][] matrix = {
							{1,2,3,4,5},
							{16,17,18,19,6},
							{15,24,25,20,7},
							{14,23,22,21,8},
							{13,12,11,10,9}
						};
		spiral(matrix);
	}

	public static void spiral(int[][] matrix) {
		int top=0;
		int bottom=matrix.length - 1;
		int left=0;
		int right=matrix[0].length - 1;

		while(true) {
			if(left>right) {
				break;
			}
			//top
			for(int i=left; i<=right; i++) {
				System.out.println(matrix[top][i]);
			}
			top++;
			//right
			for(int i=top; i<=bottom; i++) {
				System.out.println(matrix[i][right]);	
			}
			right--;
			//bottom
			for(int i=right; i>=left; i--) {
				System.out.println(matrix[bottom][i]);	
			}
			bottom--;
			//left
			for(int i=bottom; i>=top; i--) {
				System.out.println(matrix[i][left]);	
			}
			left++;
		}
	}
}