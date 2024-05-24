import java.util.*;

class NumberOfOperationsToMakeNetworkConnected {
	public static void main(String args[]) {
		// int n = 4;
		// int[][] connections = {{0,1},{0,2},{1,2}};
		// int n = 6;
		// int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
		int n = 11;
		int[][] connections = {{1,4},{0,3},{1,3},{3,7},{2,7},{0,1},{2,4},{3,6},{5,6},{6,7},{4,7},{0,7},{5,7}};
		System.out.println(makeConnected(n, connections));
		System.out.println(makeConnected_quickUnion(n, connections));
	}

	//Using union - QuickFind will work. QuickUnion will not. however DFS has better performance than QuickFind
	// Quick Find root vals after union - 5, 5, 5, 5, 5, 5, 5, 5, 8, 9, 10
	// Quick Union root vals after union - 0, 0, 2, 1, 2, 5, 5, 5, 8, 9, 10
	public static int makeConnected_quickUnion(int n, int[][] connections) {
		if(connections.length<n-1) {
			return -1;
		}
		QuickFind qu = new QuickFind(n);
		for(int[] connection: connections) {
			qu.union(connection[0], connection[1]);
		}

		for(int i: qu.root) {
			System.out.print(i+", ");
		}

		int groups = 0;
		for(int i=0; i<n; i++) {
			if(qu.root[i]==i) {
				groups++;
			}
		}

		return groups - 1;
	}


	public static int makeConnected(int n, int[][] connections) {
        if(n>connections.length+1) {
            return -1;
        }
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        List<Integer> tempList;
        for(int i=0; i<n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for(int[] connection: connections) {
            adjacencyList.get(connection[0]).add(connection[1]);
            adjacencyList.get(connection[1]).add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        int isolated = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visit_dfs(i, adjacencyList, visited);
                isolated++;
            }
        }
        
        return isolated-1;
    }
    
    public static void visit_dfs(int comp,  Map<Integer, List<Integer>> graph, boolean[] visited) {
        if(!visited[comp]) {
            visited[comp]=true;
            for(int neighbor: graph.get(comp)) {
                visit_dfs(neighbor, graph, visited);
            }
        }
    }
}

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

class QuickUnion1 {
	int[] root;

	public QuickUnion1(int n) {
		root = new int[n];
		for(int i=0; i<n; i++) {
			root[i]=i;
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
			root[y] = rootx;
		}
	}
}