import java.util.*;

// incorrect
class GraphValidTree {
	public static void main(String args[]) {
		int n = 5; 
		int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		// false expected
		System.out.println(validTree(n, edges));
	}

    public static boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

				for(int i=0; i<n; i++) {
					map.put(i, new ArrayList<>());
				}

				for(int[] edge: edges) {
					map.get(edge[0]).add(edge[1]);
					map.get(edge[1]).add(edge[0]);
				}
				Set<Integer> visited = new HashSet<>();
				return dfs(0, map, visited, -1);
    }

	public static boolean dfs(int curr,  Map<Integer, List<Integer>> map, Set<Integer> visited, int parent) {
		System.out.println(parent+":"+curr+": "+visited);
		if(visited.contains(curr)) return false;
		visited.add(curr);
		for(int n: map.get(curr)) {
			if(parent!=n && !dfs(n, map, visited, curr)) {
				return false;
			}
		}
		return true;
	}
}