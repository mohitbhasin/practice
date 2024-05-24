import java.util.*;


// Bidirectional Graph
//Using BFS
class FindIfPathExistInGraph {
	public static void main(String args[]) {
		int n = 3; 
		int[][] edges = {{0,0}, {0,0}, {0,1},{1,2},{2,0}};
		int source = 0; 
		int destination = 2;

		System.out.println(checkPath(source, destination, edges, n));
	}

	public static boolean checkPath(int source, int dest, int[][] edges, int n) {
		List<List<Integer>> adjList = new ArrayList<>();
		Set<Integer> visisted = new HashSet<>();
		for(int i=0; i<n; i++) {
			adjList.add(new ArrayList<>());
		}

		for(int[] edge: edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		Queue<Integer> que = new LinkedList<>();
		que.offer(source);

		while(!que.isEmpty()) {
			System.out.println(que);
			int curr = que.poll();
			if(curr==dest) {
				return true;
			}

			for(int next: adjList.get(curr)) {
				if(!visisted.contains(next)) {
					visisted.add(next);
					que.offer(next);
				}
			}
		}

		return false;
	}
}