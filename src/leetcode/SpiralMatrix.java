class SpiralMatrix {
	public static void main(String args[]) {
		int[][] matrix = {
							{1,2,3,4,5},
							{16,17,18,19,6},
							{15,24,25,20,7},
							{14,23,22,21,8},
							{13,12,11,10,9}
		};
		print(matrix);
	}

	public static void print(int[][] matrix) {
		int top=0; int bottom = matrix.length-1;
		int left=0; int right = matrix[0].length-1;
		while(true) {
			if(left>right) {
				break;
			}
			for(int i=top; i<=right; i++) {
				System.out.print(matrix[top][i]+", ");
			}
			for(int i=right-1; i<=bottom; i++) {
				System.out.print(matrix[right][i]+", ");
			}
			for(int i=bottom-1; i>=left; i--) {
				System.out.print(matrix[bottom][i]+", ");
			}
			for(int i=left-1; i<=top; i--) {
				System.out.print(matrix[left][i]+", ");
			}
			top++;
			bottom--;
			left++;
			right--;			
		}
	}
}