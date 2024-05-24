import java.util.*;

class AllPathsFromSourceToTarget {
	public static void main(String args[]) {
		int[][] graph = {{1,2},{3},{3},{}};
		System.out.println(allPaths(graph));
	}

	public static List<List<Integer>> allPaths(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		dfs(graph, result, path, 0, graph.length-1);
		return result;
	}

	public static void dfs(int[][] graph, List<List<Integer>> result, List<Integer> curr, int source, int destination) {
		if(source==destination) {
			result.add(new ArrayList<>(curr));
			return;
		}
		for(int neighbor: graph[source]) {
			curr.add(neighbor);
			dfs(graph, result, curr, neighbor, destination);
			curr.remove(curr.size() - 1);
		}
	}
}