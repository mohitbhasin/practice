import java.util.*;

class RotateMatrixSimpleTranspose {
	public static void main(String args[]) {
		int[][] matrix = {
							{1,2,3,4,5},
							{16,17,18,19,6},
							{15,24,25,20,7},
							{14,23,22,21,8},
							{13,12,11,10,9}
						};
		swap(matrix);
		for(int[] arr: matrix) {
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void swap(int[][] mat) {
		for(int i=0; i<mat.length; i++) {
			for(int j=0; i<mat.length; i++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}	
		}
	}
}