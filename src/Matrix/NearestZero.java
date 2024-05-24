import java.util.*;

class NearestZero {
	public static void main(String args[]) {
		int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
		updateMatrix(mat);
		for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
            	System.out.print(mat[i][j]+", ");
            }
            System.out.println();
        }
	}
	public static int[][] updateMatrix(int[][] mat) {
        Queue<List<int[]>> que;
        List<int[]> path;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j]==1) {
                    path = new ArrayList<>();
                    path.add(new int[]{i,j});
                    que = new LinkedList<>();
                    que.add(path);
                    while(!que.isEmpty()) {
                        path = que.poll();
                        int[] temp = path.get(path.size() - 1);
                        int r = temp[0];
                        int c = temp[1];
                        if(r<0 || r>mat.length-1 || c<0 || c>mat[0].length-1) {
                        	continue;
                        }
                        if(mat[r][c]==0) {
                            mat[i][j]=path.size() - 1;
                            break;
                        } else {
                            List<int[]> tempPath;
                            for(int[] dir: directions) {
                                tempPath = path;
                                tempPath.add(new int[]{r+dir[0], c+dir[1]});
                                que.offer(tempPath);
                            }
                        }
                    }
                }
            }   
        }
        return mat;
    }
}