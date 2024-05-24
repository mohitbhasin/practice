import java.util.*;

class AllPathsFromSourceLeadToDestination {
	public static void main(String args[]) {
		// int n = 4;
		// int[][] edges = {{0,1},{0,2},{1,3},{2,3}};
		// int source = 0; 
		// int destination = 3;

		int n = 2;
		int[][] edges = {{0,1},{1,1}};
		int source = 0; 
		int destination = 1;

		// int n = 4;
		// int[][] edges = {{0,1},{0,3},{1,2},{2,1}};
		// int source = 0; 
		// int destination = 3;
		// System.out.println(checkPaths(n, edges, source, destination));
		// System.out.println(leadsToDestination(n, edges, source, destination));
		System.out.println(leadsToDest(n, edges, source, destination));
	}

// using HashMap for visited (while, gray, black)
	public static boolean leadsToDest(int n, int[][] edges, int source, int destination) {
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for(int[] edge: edges) {
			// if there is outgoing edge from destination, return false. (asked in the question).
			if(edge[0]==destination) return false;
			if(!graph.containsKey(edge[0])) {
				graph.put(edge[0], new ArrayList<>());
			}
			graph.get(edge[0]).add(edge[1]);
		}

		return dfs_better(graph, source, destination, new HashMap<>());
	}

	public static boolean dfs_better(Map<Integer, List<Integer>> graph, int curr, int dest, Map<Integer, Boolean> visited) {
		if(visited.containsKey(curr)) return visited.get(curr);
		if(!graph.containsKey(curr)) return curr==dest;
		visited.put(curr, false);
		for(int neighbor: graph.get(curr)) {
			if(!dfs_better(graph, neighbor, dest, visited)) {
				return false;
			}
		}
		visited.put(curr, true);
		return true;
	}




	// The below two solutions doesn't work any more on the website. 
	// Time limit exceeds on them due to using boolean hashset (visited).
	// ading and removing node on it causes revisits on the paths.
	public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++) {
        	graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
        }

        return dfs(graph, source, destination, new HashSet<Integer>());
    }

    public static boolean dfs(List<Integer>[] graph, int curr, int dest, Set<Integer> visited) {
        if(graph[curr].isEmpty()) {
        	return curr==dest;
        }
        if(visited.contains(curr)) return false;
        visited.add(curr);
        for(int next: graph[curr]) {
            if(!dfs(graph, next, dest, visited)) {
                return false;
            }
        }
        visited.remove(curr);
        return true;
    }

	public static boolean checkPaths(int n, int[][] edges, int source, int destination ) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> adjList;
		for(int[] edge: edges) {
			if(!map.containsKey(edge[0])) {
				adjList = new ArrayList<>();
				adjList.add(edge[1]);
				map.put(edge[0], adjList);
			} else {
				map.get(edge[0]).add(edge[1]);
			}
		}
		return helper(map, source, destination, new HashSet<Integer>());
	}

	public static boolean helper(Map<Integer, List<Integer>> map, int source, int destination, Set<Integer> visited) {
		if(visited.contains(source)) {
			return false;
		}
		if(!map.containsKey(source)) {
			return source==destination;
		}
		visited.add(source);
		for(int neighbor: map.get(source)) {
			if(!helper(map, neighbor, destination, visited)) {
				return false;
			}
		}
		visited.remove(source);
		return true;
	}
}