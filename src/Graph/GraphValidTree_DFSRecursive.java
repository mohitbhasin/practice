import java.util.*;

class GraphValidTree_DFSRecursive {
	public static void main(String args[]) {
		int n = 5; 
		int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};

		// int n = 5;
		// int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
		
		System.out.println(validTree(n, edges));
	}

	public static boolean validTree(int n, int[][] edges) {
		List<Set<Integer>> adjList = new ArrayList<>();

		for(int i=0; i<n; i++) {
			adjList.add(i, new HashSet<>());
		}

		for(int[] edge: edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		Set<Integer> visited = new HashSet<>();
		return dfs(0, adjList, visited) && visited.size()==n;
	}

	public static boolean dfs(int curr, List<Set<Integer>> adjList, Set<Integer> visited) {
		if(visited.contains(curr)) return false;
		visited.add(curr);

		for(int neighbor: adjList.get(curr)) {
			if(visited.contains(neighbor)) return false;
			else {
				adjList.get(neighbor).remove(curr);
				if(!dfs(neighbor, adjList, visited)) return false;
			}
		}
		return true;
	}
}