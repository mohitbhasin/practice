import java.util.*;
class NetworkDelayTime {
	public static void main(String args[]) {
		// int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		// int n = 4; 
		// int k = 2;
		// int[][] times = {{1,2,1},{2,1,3}};
		// int n = 2; 
		// int k = 2;
		int[][] times = {{2,1,1},{2,3,1},{2,5,7},{5,4,2},{3,4,1}};
		int n = 5; 
		int k = 2;

		System.out.println(networkDelayTime(times, n, k));
	}

    public static int networkDelayTime_dijkstra(int[][] times, int n, int k) {
        
    }

	public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] timeHash = new int[n+1];
        Arrays.fill(timeHash, Integer.MAX_VALUE);
        for(int[] time: times) {
            graph.get(time[0]).add(new Pair(time[1], time[2]));
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        timeHash[k]=0;
        timeHash[0]=0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(Pair edge: graph.get(curr)) {
            	int tempTime = timeHash[curr]+edge.time;
            	int dest = edge.dest;
            	if(timeHash[dest]>tempTime) {
            		timeHash[dest]=tempTime;
            		queue.offer(dest);
            	}
            }
            
        }

        int maxTime = 0;
        for(int time: timeHash) {
        	if(time==Integer.MAX_VALUE) return -1;
        	maxTime=Math.max(maxTime,time);
        }

        return maxTime;
    }
}

class Pair {
	int dest;
	int time;	public Pair(int dest, int time) {
		this.dest=dest;
		this.time=time;
	}
}