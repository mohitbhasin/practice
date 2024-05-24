class NumberOfProvince {
	public static void main(String args[]) {
		// int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
		// int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
		int[][] isConnected = {
			{1,1,0,1,0,0},
			{1,1,0,0,0,0},
			{0,0,1,0,0,0},
			{1,0,0,1,1,0},
			{1,0,0,1,1,0},
			{0,0,0,0,0,1},
		};
		System.out.println(countProvince(isConnected));
	}

	public static int countProvince(int[][] isConnected) {
		int n=isConnected.length;
		QuickUnion uf = new QuickUnion(n);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(isConnected[i][j]==1) {
					uf.union(i, j);
				}
			}		
		}
		int[] root = uf.root;

		int count = 0;
		for(int i=0; i<n; i++) {
			if(root[i]==i) {
				count++;
			}
		}
		return count;
	}

}