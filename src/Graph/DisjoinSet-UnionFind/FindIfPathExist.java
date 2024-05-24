import java.util.*;

//Undirected graph Or Bidirectional graph
class FindIfPathExist {
	public static void main(String args[]) {
		// int n = 6;
		// int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}}; 
		// int source = 0;
		// int destination = 5;

		int n = 3;
		int[][] edges = {{0,1},{1,2},{2,0}};
		int source = 0;
		int destination = 2;

		System.out.println(findPath(n, edges, source, destination));
		System.out.println(findPath_dfs_stack_adjacencyList(n, edges, source, destination));
	}

	public static boolean findPath(int n, int[][] edges, int source, int destination) {
		QuickFind qu = new QuickFind(n);
		for(int[] edge: edges) {
			qu.union(edge[0], edge[1]);
		}

		return qu.root[source] == qu.root[destination];
    }

    public static boolean findPath_dfs_stack_adjacencyList(int n, int[][] edges, int source, int destination) {
    	List<List<Integer>> adjacencyList = new ArrayList<>();
    	for(int i=0; i<n; i++) {
    		adjacencyList.add(new ArrayList<>());
    	}

    	for(int[] edge: edges) {
    		adjacencyList.get(edge[0]).add(edge[1]);
    		adjacencyList.get(edge[1]).add(edge[0]);
    	}

    	Stack<Integer> stack = new Stack<>();
    	stack.push(source);
    	Set<Integer> visisted = new HashSet<>();
    	while(!stack.isEmpty()) {
    		int val = stack.pop();

    		if(destination==val) {
    			return true;
    		}
    		if(!visisted.contains(val)) {
    			visisted.add(val);
	    		for(int adjacent: adjacencyList.get(val)) {
	    			stack.push(adjacent);
	    		}
    		}
    	}
    	return false;
    }

}