import java.util.*;

class UniquePaths {
	public static void main(String args[]) throws Exception {
		System.out.println(uniquePaths(3, 7)); 
		System.out.println(uniquePaths2(3, 7));
	}

	public static int uniquePaths2(int m, int n) {
        int[][] matrix = new int[m][n];
        for(int[] arr: matrix) {
            Arrays.fill(arr, 1);
        }

        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                matrix[i][j]=matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }

	public static int uniquePaths(int m, int n) {
		int[][] map = new int[m][n];
        int result = helper(0, 0, m-1, n-1, map);
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		System.out.print(map[i][j]+", ");
        	}
        	System.out.println();
        }
        return result;
    }

 	public static int helper(int curr_x, int curr_y, int x, int y, int[][] map) {
    	if(curr_x==x && curr_y==y) {
            return 1;
        }
        if(curr_x>x || curr_y>y) {
            return 0;
        }

        if(map[curr_x][curr_y]!=0) {
        	return map[curr_x][curr_y];
        }

        int result = helper(curr_x+1, curr_y, x, y, map) + helper(curr_x, curr_y+1, x, y, map);
        map[curr_x][curr_y]=result;

        return result;
    }
}