import java.util.*;

// TODO
class IsGraphBipartite {
	public static void main(String args[]) {
		// int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
		// int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
		// int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
		int[][] graph = {{4},{},{4},{4},{0,2,3}};

		System.out.println(isBipartite(graph));
	}

	public static boolean isBipartite(int[][] graph) {
        setA = new HashSet<>();
        setB = new HashSet<>();
        dfs(graph, 0, true, new HashSet<>());
        System.out.println(setA);
        System.out.println(setB);
        for(int i=0; i<graph.length; i++) {
            if((setA.contains(i) && setB.contains(i)) || (!setA.contains(i) && !setB.contains(i))) {
                return false;
            }
        }
        return true;
    }
    
    static Set<Integer> setA;
    static Set<Integer> setB;
    
    public static void dfs(int[][] graph, int curr, boolean set, Set<Integer> visited) {
        if((set && setA.contains(curr)) || (!set && setB.contains(curr))) return;
        visited.add(curr);
        if(set) {
            setA.add(curr);
            set=false;
        } else {
            setB.add(curr);
            set=true;
        }
        int[] neighbors = graph[curr];
        for(int neighbor: neighbors) {
            dfs(graph, neighbor, set, visited);
        }
    }
}