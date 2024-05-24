import java.util.*;
// check all paths from source leads to destination 
// Directed Graph
class AllPathFromSourceToDestincation {
	public static void main(String args[]) {
		// int n = 4;
		// int[][] edges = {{0,1},{0,2},{1,3},{2,3}};
		// int source = 0;
		// int destination = 3;

		// int n = 3;
		// int[][] edges = {{0,1},{1,1},{1,2}};
		// int source = 0;
		// int destination = 2;

		// int n = 4;
		// int[][] edges = {{0,1},{0,3},{1,2},{2,1}};
		// int source = 0;
		// int destination = 3;

		// int n = 3;
		// int[][] edges = {{0,1},{0,2}};
		// int source = 0;
		// int destination = 2;

		int[][] edges = {{0,1},{0,2},{2,1},{1,3}};
        int n = 4;
        int source = 0;
        int destination = 3;


		System.out.println(checkPath(n, edges, source, destination));
	}

	public static boolean checkPath(int n, int[][] edges, int source, int destination) {
		Map<Integer, List<Integer>> connected = new HashMap<>();

		for(int i=0; i<n; i++) {
			connected.put(i, new ArrayList<>());
		}

		for(int[] edge: edges) {
			connected.get(edge[0]).add(edge[1]);
		}

		Set<Integer> visisted = new HashSet<>();

		return dfs(source, destination, connected, visisted);
	}

	public static boolean dfs(int source, int destination, Map<Integer, List<Integer>> connected, Set<Integer> visisted) {
		if(visisted.contains(source)) {
			return false;
		}
		visisted.add(source);
		for(int next: connected.get(source)) {
			if(!dfs(next, destination, connected, visisted)) {
				return false;
			}
		}
		return true;
	}
}








