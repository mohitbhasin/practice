import java.util.*;

class RedundantConnection {
	public static void main(String[] args) {
		int[][] edges = {{1,2},{1,3},{2,3}};
		int[] output= findRedundantConnection(edges);
		System.out.println(output[0]+", "+output[1]);

		edges = new int[][] {{1,2},{2,3},{3,4},{1,4},{1,5}};
		output= findRedundantConnection(edges);
		System.out.println(output[0]+", "+output[1]);
	}

    static int[] parent;
    static int[] rank;

	public static int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for(int i=0; i<parent.length; i++) parent[i]=i;
        rank = new int[edges.length+1];
        Arrays.fill(rank, 1);
        for(int[] edge: edges) {
        	if(!union(edge[0], edge[1])) {
        		return new int[] {edge[0], edge[1]};
        	}
        }
        return null;
    }

    public static int find(int x) {
    	int p = parent[x];

    	while(p!=parent[p]) {
    		p=parent[p];
    	}
    	return p;
    }

    // return false if both parent are same and union already done,
    // which means this edge is redundant.
    public static boolean union(int x, int y) {
    	int parentA = find(x);
    	int parentB = find(y);

    	if(parentA==parentB) {
    		return false;
    	}
		if(rank[parentA]>rank[parentB]) {
			parent[parentB]=parentA;
			rank[parentA]+=rank[parentB];

		} else {
			parent[parentA]=parentB;
			rank[parentB]+=rank[parentA];
		}
    	return true;
    }
}