import java.util.*;

class ShortestPathInBinaryMatrix {
	public static void main(String args[]) {
		int[][] matrix = {
			// {0,0,0},
			// {1,1,0},
			// {1,1,0}

			// {0,1}, {1,0}

			{0,0,0,1,0,0,0},
			{0,1,1,1,0,0,0},
			{0,1,0,0,0,1,1},
			{0,0,1,1,1,0,1},
			{0,1,1,1,0,0,0},
		};

		System.out.println(shortestPathBinaryMatrix(matrix));
	}
	// Better and simple - updating matrix,
	public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0) {
            return -1;
        }
        int[][] directions = {{1,0},{0,1},{1,1},{-1,0},{-1,1},{-1,-1},{0,-1},{1,-1}};
        grid[0][0]=1;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        int r=0;
        int c=0;
        while(!que.isEmpty()) {
            int[] curr = que.poll();
            r = curr[0];
            c = curr[1];
            int distance = grid[r][c];
	        if(r==grid.length-1 && c==grid[0].length-1) {
	            return distance;
	        }
            for(int[] direction: directions) {
                int new_r = r+direction[0];
                int new_c = c+direction[1];
                if(new_r>=0 && new_r<grid.length && new_c>=0 && new_c<grid[0].length && grid[new_r][new_c]==0) {
                    grid[new_r][new_c]=distance+1;
                    que.offer(new int[]{new_r, new_c});                    
                }
            }
        }
        return -1;
    }
    // storing list of paths in queue during BFS. Pair class can be avoided with int[].
	public static int findPath(int[][] matrix) {
		Queue<List<Pair>> que = new LinkedList<>();
		List<Pair> pairs = new ArrayList<>();
		pairs.add(new Pair(0,0));
		que.offer(pairs);
		int[][] directions = {{1,0},{0,1},{1,1},{-1,0},{-1,1},{-1,-1},{0,-1},{1,-1}};
		while(!que.isEmpty()) {
			List<Pair> tempPairs = que.poll();
			Pair curr = tempPairs.get(tempPairs.size()-1);
			if(curr.x<0 || curr.x>matrix.length-1 || curr.y<0 || curr.y>matrix[0].length-1 || matrix[curr.x][curr.y]==1) {
				continue;
			}
			if(curr.x==matrix.length-1 && curr.y==matrix[0].length-1) {
				return tempPairs.size();
			}
			matrix[curr.x][curr.y]=1;
			List<Pair> temp;
			for(int[] direction: directions) {
				int newX = curr.x+direction[0];
				int newY = curr.y+direction[1];
				temp = new ArrayList<>(tempPairs);
				temp.add(new Pair(newX, newY));
				que.offer(temp);
			}
		}
		return -1;
	}
}

class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public String toString() {
		return "("+x+","+y+")";
	}
}