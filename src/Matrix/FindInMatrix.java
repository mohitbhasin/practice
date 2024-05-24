class FindInMatrix {
	public static void main(String args[]) {
		int[][] matrix = {
			{1,3,5,7},
			{10,11,12,20},
			{23,30,34,60}
		};

		System.out.println(searchMatrix(matrix, 60));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int left = 0;
		int right = (m * n) - 1;
		int pivotIndex;
		while(left<=right) {
			pivotIndex=(left+right)/2;
            if(matrix[pivotIndex/n][pivotIndex%n]==target) {
                return true;
            }
            if(matrix[pivotIndex/n][pivotIndex%n]>target) {
                right=pivotIndex-1;
            } else {
                left=pivotIndex+1;
            }
		}
		return false;
    }
}