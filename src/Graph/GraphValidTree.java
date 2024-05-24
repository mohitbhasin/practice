import java.util.*;

class GraphValidTree {
	public static void main(String[] args) {
		// int n = 5; int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
		int n = 5; int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		// int n = 4; int[][] edges = {{0,1},{2,3}};
		System.out.println(validTree(n, edges));

		System.out.println(validTreeRecur(n, edges));
	}


	public static boolean validTreeRecur(int n, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++) {
        	adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
        	adjList.get(edge[0]).add(edge[1]);
        	adjList.get(edge[1]).add(edge[0]);
        }
		visited = new HashSet<>();
		helper(adjList, 0);
		return visited.size()==n;
	}
	static Set<Integer> visited;
	public static void helper(List<List<Integer>> adjList, int curr) {
		if(visited.contains(curr)) return;
		visited.add(curr);
		for(int next: adjList.get(curr)) {
			helper(adjList, next);
		}

	}

	public static boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++) {
        	adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
        	adjList.get(edge[0]).add(edge[1]);
        	adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> que = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        que.offer(0);

        while(!que.isEmpty()) {
        	System.out.println(que);
        	int curr = que.poll();
        	if(seen.contains(curr)) return false;
        	seen.add(curr);
        	for(int next: adjList.get(curr)) {
        		if(!seen.contains(next)) {
        			que.offer(next);
        		}
        	}
        }
        System.out.println(seen);
        return seen.size()==n;
    }
}