class GraphValidTree {
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
		System.out.println(validTree(n, edges));
	}

	public static boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        root = new int[n];
        for(int i=0; i<n; i++) root[i]=i;
        for(int[] edge: edges) {
            quickUnion(edge[0], edge[1]);
        }
        int count=0;
        for(int i=0; i<n; i++) {
            if(root[i]==i) count++;
            if(count>1) return false;
        }
        return true;
    }
    
    static int[] root;
    
    public static int find(int x) {
        while(x!=root[x]) {
            x=root[x];
        }
        return x;
    }
    
    public static void quickUnion(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        root[root_y]=root_x;
    }
}