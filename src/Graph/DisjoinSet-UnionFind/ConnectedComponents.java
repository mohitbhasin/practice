class ConnectedComponents {
	public static void main(String args[]) {
		int[][] edges = {{0,1},{1,2},{3,4}};
		// int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
		int n=5;
		System.out.println(countConnected(edges, n));
	}

	public static int countConnected(int[][] edges, int n) {
		QuickFind uf = new QuickFind(n);
		for(int i=0; i<edges.length; i++) {
			uf.union(edges[i][0], edges[i][1]);
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