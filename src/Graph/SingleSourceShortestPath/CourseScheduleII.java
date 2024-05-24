import java.util.*;

class CourseScheduleII {
	public static void main(String[] args) {
		// int numCourses = 4;
		// int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

		int numCourses = 3;
		int[][] prerequisites = {{1,0},{1,2},{0,1}};


		int[] result = findOrder(numCourses, prerequisites);

		for(int r: result) {
			System.out.print(r+", ");
		}
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        // never use array fill with objects. same object is copied in all indices
        // Arrays.fill(adjList, new ArrayList<>());
        for(int i=0; i<adjList.length; i++) {
        	adjList[i]=new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        for(int[] edge: prerequisites) {
            adjList[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i]==0) {
                queue.offer(i);
            }
        }
        if(queue.isEmpty()) {
        	return new int[0];
        }
        int[] result = new int[numCourses];
        int index=0;
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            result[index++]=curr;
            for(int course: adjList[curr]) {
                inDegree[course]--;
                if(inDegree[course]<0) {
                    return new int[numCourses];
                }
                if(inDegree[course]==0) {
                    queue.offer(course);
                }
            }
        }

        for(int in: inDegree) {
        	if(in!=0) {
        		return new int[0];
        	}
        }
        return result;
    }
}