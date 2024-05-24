import java.util.*;

class NumberOfConnectedComponents {
	public static void main(String args[]) {
		int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
		int n=5;
		System.out.println(countComponents(edges,n));
	}

	public static int countComponents(int[][] edges, int n) {
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for(int[] edge: edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}


		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[n];
		int count = 0;
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			count++;
			stack.push(i);
			while(!stack.isEmpty()) {
				int curr = stack.pop();
				if(visited[curr]) continue;
				visited[curr]=true;
				for(int neighbor: adjacencyList.get(curr)) {
					stack.push(neighbor);
				}
			}
		}
		return count;
	}
}