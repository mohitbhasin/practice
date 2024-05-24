import java.util.*;


//Incorrect Solution - right answer for this test cacse is 14 instead of 16;
class ShortestPathInGrid {
	public static void main(String args[]) {
		// int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}}; 
		// int k = 1;
		// int[][] grid = {{0,1,1},{1,1,1},{1,0,0}}; 
		// int k = 1;

		// output 16, expected 14
		int[][] grid = {{0,0},{1,0},{1,0},{1,0},{1,0},{1,0},{0,0},{0,1},{0,1},{0,1},{0,0},{1,0},{1,0},{0,0}};
		int k = 4;
		System.out.println(shortestPath(grid, k));

	}
	public static int shortestPath(int[][] grid, int k) {
        Queue<Pair> que = new LinkedList<>();
        Pair curr = new Pair(0,0,k,0);
        que.offer(curr);
        Set<Pair> visited = new HashSet<>();
        while(!que.isEmpty()) {
            curr=que.poll();
            if(curr.x==grid.length-1 && curr.y==grid[0].length-1) {
                return curr.count;
            }
            if(curr.x<0 || curr.x>=grid.length || curr.y<0 || curr.y>=grid[0].length || curr.remain<0 || grid[curr.x][curr.y]==2) {
                continue;
            }
            if(grid[curr.x][curr.y]==0 || (grid[curr.x][curr.y]==1 && curr.remain>0)) {
            	curr.count++;
                int remain = grid[curr.x][curr.y]==1 ? curr.remain-1 : curr.remain;
                que.offer(new Pair(curr.x+1, curr.y, remain, curr.count));
                que.offer(new Pair(curr.x, curr.y+1, remain, curr.count));
                que.offer(new Pair(curr.x-1, curr.y, remain, curr.count));
                que.offer(new Pair(curr.x, curr.y-1, remain, curr.count));                          
            }
            grid[curr.x][curr.y]=2;
        }
        return -1;
    }
}

class Pair {
    int x;
    int y;
    int remain;
    int count;
    
    Pair(int x, int y, int remain, int count) {
        this.x = x;
        this.y = y;
        this.remain = remain;
        this.count = count;
    }
}