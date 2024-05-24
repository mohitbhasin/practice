import java.util.*;

class RotateImage {
	public static void main(String args[]) {
		// int[][] matrix = {
		// 					{1,2,3,4,5},
		// 					{16,17,18,19,6},
		// 					{15,24,25,20,7},
		// 					{14,23,22,21,8},
		// 					{13,12,11,10,9}
		// 				};
		// rotate(matrix);
		// for(int[] arr: matrix) {
		// 	System.out.println(Arrays.toString(arr));
		// }
		int[][] matrix2 = {
							{1,2,3,4,5},
							{6,7,8,9,10},
							{11,12,13,14,15},
							{16,17,18,19,20},
							{21,22,23,24,25}
						};
		rotate_simple(matrix2);
		// for(int[] arr: matrix2) {
		// 	System.out.println(Arrays.toString(arr));
		// }
	}

	public static void rotate(int[][] mat) {
		for(int layer = 0; layer<mat.length/2; layer++) {
			int first=layer;
			int last=mat.length-1-layer;
			for(int i=first; i<last; i++) {
				int offset = i-first;
				int temp = mat[first][i];
				mat[first][i] = mat[last - offset][first];
				mat[last - offset][first] = mat[last][last - offset];
				mat[last][last - offset] = mat[i][last];
				mat[i][last] = temp;
			}
		}
	}

	public static void rotate_simple(int[][] matrix) {
        int n = matrix.length;
        int temp;

        for(int i=0; i<(n)/2; i++) {	// i and j condition can be swaped without issues
            for(int j=0; j<(n+1)	/2; j++) {	// i.e. i<n/2 and j<(n+1)/2
                temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
                print(matrix);
            }
        }
    }

    public static void print(int[][] matrix) {
    	for(int[] arr: matrix) {
    		System.out.println(Arrays.toString(arr));
    	}
    	System.out.println();
    }
}