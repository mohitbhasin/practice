import java.util.*;

class GraphValidTree_IterativeStack {
	public static void main(String args[]) {
		// int n = 5; 
		// int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		
		int n = 5;
		int[][] edges = {{0,1},{0,2},{0,3},{1,4}};

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
		
		Stack<Integer> stack = new Stack<>();

		stack.push(0);
		Set<Integer> visited = new HashSet<>();
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(visited.contains(curr)) return false;
			visited.add(curr);
			for(int neig: map.get(curr)) {
				if(!visited.contains(neig)) {
					stack.push(neig);
				}
			}
		}
		return visited.size()==n;
    }
}