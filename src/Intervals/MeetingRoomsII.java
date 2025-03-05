import java.util.*;

class MeetingRoomsII {
	public static void main(String args[]) {
		List<int[][]> intervalsList =  new ArrayList<>();
		intervalsList.add(new int[][] {{0,30}, {5,10}, {15,20}});
		intervalsList.add(new int[][] {{7,10},{2,4}});
		intervalsList.add(new int[][] {{1,5},{9,11},{3,10},{2,7}});

		for(int[][] intervals: intervalsList) {
			System.out.println("Total Rooms=" + minMeetingRooms(intervals));
			System.out.println("Total Rooms2=" + minMeetingRooms2(intervals));
		}
	}

	public static int minMeetingRooms(int[][] intervals) {
		if(intervals.length==0 || intervals==null) return 0;
		Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1]-b[1]);
		pq.offer(intervals[0]);
		int maxRooms = 1;
		for(int i=1; i<intervals.length; i++) {
			if(pq.peek()[1]>intervals[i][0]) {
				pq.offer(intervals[i]);
				maxRooms = Math.max(maxRooms, pq.size());
			} else {
				while(!pq.isEmpty() && pq.peek()[1]<=intervals[i][0]) {
					pq.poll();
				}
				pq.offer(intervals[i]);
			}
		}
		return maxRooms;
	}

	public static int minMeetingRooms2(int[][] intervals) {
	    if (intervals == null || intervals.length == 0) {
	        return 0;
	    }

	    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
	    int maxRooms = 0; // Initialize to 0

	    for (int[] interval : intervals) {
	        if (!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
	            pq.poll(); // Remove meetings that have ended.
	        }
	        pq.offer(interval);
	        maxRooms = Math.max(maxRooms, pq.size());
	    }
	    return maxRooms;
	}
}