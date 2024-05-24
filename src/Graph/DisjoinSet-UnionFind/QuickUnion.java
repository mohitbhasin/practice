//Quick Union more efficient than Quick Find. because quick find iterate over for loop every time.

class QuickUnion {
	int[] root;

	QuickUnion(int n) {
		root = new int[n];
		for(int i=0; i<n; i++) {
			root[i] = i;
		}
	}

	public int find(int x) {
		while(root[x]!=x) {
			x=root[x];
		}

		return x;
	}

	public void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);
		if(rootx!=rooty) {
			root[rooty]=rootx;
		}
	}
}