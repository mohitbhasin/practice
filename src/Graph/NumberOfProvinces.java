class NumberOfProvinces {
	public static void main(String args[]) {
		int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		System.out.println(findCircleNum(isConnected));
	}

	public static int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] visited = new int[isConnected.length];
        for(int row=0; row<isConnected.length; row++) {
			if(visited[row]==0) {
				markVisited(row, isConnected, visited);
	        	count++;
			}
        }
        return count;
    }
    
    public static void markVisited(int row, int[][] isConnected, int[] visited) {
    	for(int col=0; col<isConnected.length; col++) {
    		if(isConnected[row][col]==1 && visited[col]==0) {
    			visited[col]=1;
    			markVisited(col, isConnected, visited);
    		}
    	}
    }
}