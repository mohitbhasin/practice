import java.util.*;

class LongestLineOfConsecutiveOneInMatrix {
	public static void main(String args[]) {
		List<int[][]> list = new ArrayList<>();
		list.add(new int[][] {{0,1,1,0},{0,1,1,0},{0,0,0,1}});
		list.add(new int[][] {{1,1,1,1},{0,1,1,0},{0,0,0,1}});
		list.add(new int[][] {{1,1,0,0,1,0,0,1,1,0},{1,0,0,1,0,1,1,1,1,1},{1,1,1,0,0,1,1,1,1,0},{0,1,1,1,0,1,1,1,1,1},{0,0,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,0,1,1,1},{0,1,1,1,1,1,1,0,0,1},{1,1,1,1,1,0,0,1,1,1},{0,1,0,1,1,0,1,1,1,1},{1,1,1,0,1,0,1,1,1,1}});

		for(int[][] mat: list) {
			System.out.println(longestLine(mat));
		}
	}

    // Bruteforce.
	public static int longestLine(int[][] mat) {
        int[][] directions = {{0,1},{1,1},{1,0},{-1,1}};
        int n = mat.length;
        int m = mat[0].length;
        int result = 0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j]==1) {
                    for(int[] dir: directions) {
                        int x=i+dir[0];
                        int y=j+dir[1];
                        int count=1;
                        while(x>=0 && x<n && y>=0 && y<m && mat[x][y]==1) {
                            count++;
                            x+=dir[0];
                            y+=dir[1];
                        }
                        result=Math.max(result, count);
                    }
                }
            }
        }
        return result;
    }
}