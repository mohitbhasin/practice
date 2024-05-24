import java.util.*;

class ShortestDistanceFromAllBuildings {
	public static void main(String args[]) {
		int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(shortestDistance(grid));
	}

	public static int shortestDistance(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        
        // for(int i=0; i<grid.length; i++) {
        //     for(int j=0; j<grid[0].length; j++) {
        //         if(grid[i][j]==1) que.offer(new int[]{i,j});
        //     }
        // }
        int result = Integer.MAX_VALUE;
         for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==0) {
                    result=Math.min(bfs(grid, new LinkedList<>(que), i, j), result);
                }
            }
        }
        return result;
    }
    
    public static int bfs(int[][] grid, Queue<int[]> que, int i, int j) {
        int dis=0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int oneCount = que.size();
        while(!que.isEmpty() && oneCount>0) {
            
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];
            
            if(grid[x][y]==2 && visited[x][y]) continue;
            dis++;
            visited[x][y]=true;
            if(x==i && y==i) {
            	oneCount--;
            	visited[x][y]=false;
            }
            
            if(x+1>=0 && x+1<grid.length && y>=0 && y<grid[0].length) que.offer(new int[]{x+1, y});
            if(x-1>=0 && x-1<grid.length && y>=0 && y<grid[0].length) que.offer(new int[]{x-1, y});
            if(x>=0 && x<grid.length && y+1>=0 && y+1<grid[0].length) que.offer(new int[]{x, y+1});
            if(x>=0 && x<grid.length && y-1>=0 && y-1<grid[0].length) que.offer(new int[]{x, y-1});
        }
        return dis;
    }
}