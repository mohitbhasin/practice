import java.util.*;

class NonOverlappingIntervals {
	public static void main(String args[]) {
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		System.out.println(eraseOverlapIntervals(intervals));
	}

	public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<2) return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prev = 0;
        int curr = 1;
        int count = 0;
        while(curr<intervals.length) {
            if(intervals[prev][1]>intervals[curr][0]) {
                prev = intervals[curr][1]>intervals[prev][1] ? prev : curr;
                count++;
            } else {
                prev=curr;
            }
            curr++;
        }
        return count;
    }
}