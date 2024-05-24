//incomplete
class PathWithMinimumEffort {
	public static void main(String args[]) {
		int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
		System.out.println(minimumEffortPath(heights));
	}
	private static int[][] directions;
    public static int minimumEffortPath(int[][] heights) {
        directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] diffMatrix = new int[][]
        return dfs(heights, new int[heights.length][heights[0].length], 0, 0, heights[0][0]);
    }
    
    public static int dfs(int[][] heights, int[][] diffMatrix, int i, int j, int absDiff) {
        if(i==heights.length-1 && j==heights[0].length-1) {
            return absDiff;
        }
        
        int maxDiff = Integer.MAX_VALUE;
        for(int[] dir: directions) {
            int new_i = i+dir[0];
            int new_j = j+dir[1];
            if(new_i<0 || new_i>=heights.length || new_j<0 || new_j>=heights[0].length || visited[new_i][new_j]) {
                continue;
            }
            maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[new_i][new_i]));
            diffMatrix[new_i][new_j]=ma

            result=Math.min(result, dfs(heights, visited, i+dir[0], j+dir[1], Math.max(absDiff, Math.abs(heights[i][j]-heights[new_i][new_i]))));
        }
        return result;
    }
}