import java.util.*;

class Temp {
	public static void main(String args[]) {
        int[][] edges = {{}};
        int n = 6, source = 0, destination = 19999;
		// int[][] edges = {{2,9},{7,8},{5,9},{7,2},{3,8},{2,8},{1,6},{3,0},{7,0},{8,5}};
        // int n = 10, source = 1, destination = 0;
		System.out.println(validPath(n, edges, source, destination));
	}

	 public static boolean validPath(int n, int[][] edges, int source, int destination) {
       Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<n; i++) adjList.put(i, new ArrayList<>());
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        Set<Integer> visited = new HashSet<>();
        while(!que.isEmpty()) {
            int curr = que.poll();
            if(curr==destination) return true;
            visited.add(curr);
            for(int neighbor: adjList.get(curr)) {
                if(!visited.contains(neighbor)) {
                    que.offer(neighbor);
                }
            }
        }
        return false;
    }
}