import java.util.*;

class FindAllPaths {
	static Set<Integer> visited;

	public static void main(String args[]) {
		int[][] graph = {{1,2},{3},{3},{}};
		// int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
		System.out.println(returnPaths(graph));
		// System.out.println(graph.length);
	}

	public static List<List<Integer>> returnPaths(int[][] graph) {
		visited = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		findPaths(graph, 0, graph.length-1, path, result);

		return result;
	}

	public static void findPaths(int[][] graph, int source, int target, List<Integer> path, List<List<Integer>> result) {
		if(source==target) {
			result.add(new ArrayList<>(path));
			return;
		}

		for(int neighbor: graph[source]) {
			path.add(neighbor);
			findPaths(graph, neighbor, target, path, result);
			path.remove(path.size() - 1);
		}
	}
}