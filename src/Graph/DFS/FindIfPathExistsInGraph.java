import java.util.*;

class FindIfPathExistsInGraph {
	public static void main(String args[]) {
		// int n = 3;
		// int source = 0;
		// int destination = 2;
		// int[][] edges = {{0,1},{1,2},{2,0}};
		int n = 6;
		int source = 0;
		int destination = 5;
		int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
		System.out.println(findIfPathExists(n, edges, source, destination));
	}

	public static boolean findIfPathExists(int n, int[][] edges, int source, int destination) {
		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

		for(int i=0; i<n; i++) {
			adjacencyList.put(i, new ArrayList<Integer>());
		}

		for(int[] edge: edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		return dfs(adjacencyList, source, destination, new HashSet<Integer>());
	}

	public static boolean dfs(Map<Integer, List<Integer>> adjacencyList, int source, int destination, Set<Integer> visited) {
		if(source==destination) {
			return true;
		}

		if(visited.contains(source)) {
			return false;
		}

		visited.add(source);
		for(int neighbor: adjacencyList.get(source)) {
			if(dfs(adjacencyList, neighbor, destination, visited)) {
				return true;
			}
		}

		return false;
	}



}