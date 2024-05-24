import java.util.*;

class PacificAtlanticWaterFlow {
	public static void main(String args[]) {
		// int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int[][] heights = {{1,1},{1,1},{1,1}};
		System.out.println(pacificAtlantic(heights));
		// pacificAtlantic(heights);
	}

	public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r_length = heights.length;
        int c_length = heights[0].length;
        Queue<int[]> pacificQue = new LinkedList<>();
        Queue<int[]> atlanticQue = new LinkedList<>();

        for(int i=0; i<c_length; i++) {
            pacificQue.offer(new int[] {0, i});
            atlanticQue.offer(new int[] {r_length-1, i});
        }
        for(int i=0; i<r_length; i++) {
            pacificQue.offer(new int[] {i, 0});
            atlanticQue.offer(new int[] {i, c_length-1});
        }

        boolean[][] p_visited = bfs(pacificQue, heights);
        boolean[][] a_visited = bfs(atlanticQue, heights);
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pair;
        for(int i=0; i<heights.length; i++) {
            for(int j=0; j<heights[0].length; j++) {
                if(p_visited[i][j] && a_visited[i][j]) {
                    pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    result.add(pair);
                }
            }
        }
        return result;
    }

    public static boolean[][] bfs(Queue<int[]> queue, int[][] heights) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            if(visited[cell[0]][cell[1]]) {
                continue;
            }
            visited[cell[0]][cell[1]]=true;
            for(int[] dir: directions) {
                int r = cell[0]+dir[0];
                int c = cell[1]+dir[1];
                if(r>=0 && r<heights.length && c>=0 && c<heights[0].length && heights[r][c]>=heights[cell[0]][cell[1]]) {
                    queue.offer(new int[] {r,c});
                }
            }
        }
        return visited;
    }
}