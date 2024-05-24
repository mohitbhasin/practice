class BinarySearch {
	public static void main(String args[]) {
		int[] matrix = {-1, 0, 3, 5, 9, 12};
		System.out.println("3 -> "+search(matrix, 3));
		System.out.println("5 -> "+search(matrix, 5));
		System.out.println("12 -> "+search(matrix, 12));
		System.out.println("-1 -> "+search(matrix, -1));
		System.out.println("0 -> "+search(matrix, 0));
		System.out.println("9 -> "+search(matrix, 9));
		System.out.println("-4 -> "+search(matrix, -4));
		System.out.println("4 -> "+search(matrix, 4));
		System.out.println("13 -> "+search(matrix, 13));
	}

	public static boolean search(int[] matrix, int target) {
		int left = 0;
		int right = matrix.length-1;
		int mid;
		while(left<=right) {
			// left + (right - left) / 2 is ideal for large numbers to avoid overflow.
			// 
			mid = (left+right)/2;
			if(matrix[mid]==target) {
				return true;
			}
			//search right
			if(matrix[mid]<target) {
				left=mid+1;
			}
			// search left
			else {
				right=mid-1;
			}
		}
		return false;
	}
}