import java.util.*;

class KClosestPoints {
	public static void main(String args[]) {
		int[][] points = {{5, 5}, {3, 3}, {4, 4}};
	    int k = 2;

	    for(int[] point: findClosest(points, k)) {
	      System.out.print("["+point[0]+point[1]+"], ");
	    }
	}

	public static List<int[]> findClosest(int[][] points, int k) {
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
	      Double hypoA = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
	      Double hypoB = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
	      return hypoB.compareTo(hypoA);
	    });

	    for(int[] point: points) {
	      pq.offer(point);
	      if(pq.size()>k) {
	        pq.poll();
	      }
	    }
	    return new ArrayList<>(pq);
  }
}