import java.util.*;

class FindPeakElementII {
	public static void main(String args[]) {
		List<int[][]> matList = Arrays.asList(
			new int[][] {{1,4},{3,2}},
			new int[][] {{10,20,15},{21,30,14},{7,16,32}},
			new int[][] {{1,2,6},{3,4,5}}
		);

		for(int[][] mat: matList) {
			for(int val: findPeakGrid(mat)) {
				System.out.print(val+", ");
			}
			System.out.println();
		}
	}

	public static int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int col_left = 0;
        int col_right = mat[0].length-1;
        int i=0;
        while(col_left<col_right) {
            int j = col_left+(col_right-col_left)/2;
            i = findMaxRow(mat, j);
            if(j==0 && mat[i][j]>mat[i][j+1] || j==m-1 && mat[i][j]>mat[i][j-1]) {
                return new int[] {i,j};
            }
            if(mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i][j+1]) {
                return new int[] {i,j};
            }
            else if(mat[i][j]>mat[i][j+1]) {
                col_right=j;
            } else {
                col_left=j+1;
            }
        }
        i = findMaxRow(mat, col_right);
        return new int[] {i, col_right};
    }
    
    public static int findMaxRow(int[][] matrix, int col) {
        int max = matrix[0][col];
        int index = 0;
        for(int i=1; i<matrix.length; i++) {
            if(matrix[i][col]>max) {
                max=matrix[i][col];
                index = i;
            }
        }
        return index;
    }
}