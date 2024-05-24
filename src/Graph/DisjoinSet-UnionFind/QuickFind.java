//Quick Union more efficient than Quick Find. because quick find iterate over for loop every time.

class QuickFind {
	int[] root;

	QuickFind(int n) {
		this.root = new int[n];
		for(int i=0; i<n; i++) {
			root[i] = i;
		}
	}

	public int find(int x) {
		return root[x];
	}

	public void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);

		if(rootx!=rooty) {
			for(int i=0; i<root.length; i++) {
				if(root[i]==rooty) {
					root[i]=rootx;
				}
			}
		}
	}

	public boolean connected(int x, int y) {
		return root[x]==root[y];
	}
}