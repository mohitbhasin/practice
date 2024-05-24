import java.util.*;

class ZerOneMatrix {
	public static void main(String args[]) {
		int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};

		int[][] matrix = updateMatrix(mat);

		for(int[] row: matrix) {
			for(int ele: row) {
				System.out.print(ele+", ");
			}
			System.out.println();
		}
	}

	static int[][] directions;
    public static int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        Queue<int[]> que = new LinkedList<>();
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j]==0) {
                    que.add(new int[]{i,j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!que.isEmpty()) {
            int[] curr = que.poll();
            int curr_x = curr[0];
            int curr_y = curr[1];
            int curr_dis = distance[curr_x][curr_y];
            for(int[] dir: directions) {
                int next_x = curr_x + dir[0];
                int next_y = curr_y + dir[1];
                if(next_x>=0 && next_x<distance.length && next_y>=0 && next_y<distance[0].length && curr_dis+1 < distance[next_x][next_y]) {
                    distance[next_x][next_y] = curr_dis + 1;
                    que.offer(new int[] {next_x, next_y});
                }
            }
        }
        return distance;
    }
}