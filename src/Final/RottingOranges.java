import java.util.*;

class RottingOranges {
	public static void main(String args[]) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(grid));
	}


     public static int orangesRotting(int[][] grid) {
       int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int fresh = 0;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==2) {
                    que.offer(new int[]{i,j});
                } else if(grid[i][j]==1) {
                    fresh++;
                }
            }
        }
        if(que.isEmpty()) {
            if(fresh>0) return -1;
            else return 0;
        }
        int minutes = -1;
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i=0; i<size; i++) {
                int[] pair = que.poll();
                for(int[] dir: directions) {
                    int x = pair[0]+dir[0];
                    int y = pair[1]+dir[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1) {
                        grid[x][y] = 2;
                        que.offer(new int[]{x,y});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return fresh==0 ? minutes : -1;
    }
}