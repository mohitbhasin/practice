import java.util.*;

class AllPathsFromSourceToTarget {
	public static void main(String args[]) {
		int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
		System.out.println(getAllPaths(graph));
		System.out.println(getAllPaths_variant(graph));

	}

	public static List<List<Integer>> getAllPaths(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		Queue<List<Integer>> que = new LinkedList<>();
		que.offer(path);

		while(!que.isEmpty()) {
			List<Integer> currPath = que.poll();
			int val = currPath.get(currPath.size()-1);
			if(val==graph.length-1) {
				result.add(currPath);
			} else {
				for(int next: graph[val]) {
					List<Integer> nextPath = new ArrayList<>(currPath);
					nextPath.add(next);
					que.offer(nextPath);

				}
			}
		}

		return result;
	}


	//slower for some reason for using same path while adding and reamoveing elements
	public static List<List<Integer>> getAllPaths_variant(int[][] graph) {
        int source=0;
        int destination=graph.length-1;
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        Queue<List<Integer>> que = new LinkedList<>();
        path.add(0);
        que.offer(path);
        while(!que.isEmpty()) {
            path=que.poll();
            int curr = path.get(path.size()-1);
            if(curr==destination) {
                result.add(path);
                continue;
            }
            for(int next: graph[curr]) {
                path.add(next);
                que.offer(new ArrayList(path));
                path.remove(path.size()-1);
            }
        }
        return result;
    }
}