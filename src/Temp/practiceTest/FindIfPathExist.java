import java.util.*;

class FindIfPathExist {
	public static void main(String args[]) {
		int n = 3;
		int[][] edges = {{0,1},{1,2},{2,0}};
		int source = 0; 
		int destination = 2;
		System.out.println(checkPath(edges, source, destination));
	}

	public static boolean checkPath(int[][] edges, int source, int destination) {
		Map<Integer, Set<Integer>> adjacentMap = new HashMap<>();
		Set<Integer> adjacentSet;
		for(int[] edge: edges) {
			if(!adjacentMap.containsKey(edge[0])) {
				adjacentSet = new HashSet<>();
				adjacentSet.add(edge[1]);
				adjacentMap.put(edge[0], adjacentSet);
			} else {
				adjacentSet = adjacentMap.get(edge[0]);
                adjacentSet.add(edge[1]);
                adjacentMap.put(edge[0], adjacentSet);
			}
		}

		while(!adjacentMap.get(source).isEmpty()) {
			for(int des: adjacentMap.get(source)) {
				adjacentMap.get(source).remove(des);
				if(des == destination) {
					return true;
				}
			}
		}
		return false;
	}
}