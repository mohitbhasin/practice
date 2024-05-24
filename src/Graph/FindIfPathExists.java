import java.util.*;

class FindIfPathExists {
	public static void main(String args[]) {
		// int[][] edges = {{0,1},{1,2},{2,0}};
		// int n=3;
		// int source = 0;
		// int destination = 2;
		int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
		int n=6;
		int source = 0;
		int destination = 5;
		System.out.println(ifPathExists(edges,n,source,destination));
	}

	public static boolean ifPathExists(int[][] edges, int n, int source, int destination) {
		List<List<Integer>> adjacencyList = new ArrayList<>();
		//List is used instead of Map because both row and coloumn of each edge is added
		for(int i=0; i<n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for(int[] edge: edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}
		// Using list instead of map is concise in this case as elements start from 0 : n-1

		// Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
		// List<Integer> adjacencyList;
		// for(int edge[]: edges) {
		// 	if(!adjacencyMap.containsKey(edge[0])) {
		// 		adjacencyList = new ArrayList<>();
		// 		adjacencyList.add(edge[1]);
		// 		adjacencyMap.put(edge[0], adjacencyList);
		// 	} else {
		// 		adjacencyList = adjacencyMap.get(edge[0]);
		// 		adjacencyList.add(edge[1]);
		// 	}

		// 	if(!adjacencyMap.containsKey(edge[1])) {
		// 		adjacencyList = new ArrayList<>();
		// 		adjacencyList.add(edge[0]);
		// 		adjacencyMap.put(edge[1], adjacencyList);
		// 	} else {
		// 		adjacencyList = adjacencyMap.get(edge[0]);
		// 		adjacencyList.add(edge[1]);
		// 	}
		// }

		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		boolean[] visited = new boolean[n];
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(curr==destination) return true;
			if(visited[curr]) continue;
			visited[curr]=true;
			for(int dest: adjacencyList.get(curr)) {
				stack.push(dest);
			}
		}
		return false;

	}
}