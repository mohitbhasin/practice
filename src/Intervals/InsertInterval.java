import java.util.*;

class InsertInterval {
	public static void main(String args[]) {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4,8};

		int[][] result = insert(intervals, newInterval);

		for(int[] curr: result) {
			System.out.print("["+curr[0]+", "+curr[1]+"]");
		}
	}

	// this has better performance on leetcode. 
	public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) return new int[][] {newInterval};
        List<int[]> intervalList = new ArrayList<>();
        for(int[] interval: intervals) {
            if(interval[0]>newInterval[0]) {
                intervalList.add(newInterval);
            }
            intervalList.add(interval);
        }
        if(intervalList.size()==intervals.length) intervalList.add(newInterval);
        
        int prev=0;
        int curr=1;
        while(curr<intervalList.size()) {
            int[] prevInterval = intervalList.get(prev);
            int[] currInterval = intervalList.get(curr++);
            if(prevInterval[1]>=currInterval[0]) {
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            } else {
                intervalList.set(++prev, currInterval);
            }
        }
        return intervalList.subList(0, prev+1).toArray(new int[prev+1][]);
    }

	public static int[][] insert_II(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));

		for(int i=0; i<intervalList.size(); i++) {
			if(intervalList.get(i)[0]>newInterval[0]) {
				intervalList.add(i, newInterval);
				break;
			}
		}
		if(intervalList.size()==intervals.length) intervalList.add(newInterval);
		return mergeIntervals(intervalList);
    }

	public static int[][] mergeIntervals(List<int[]> intervalList) {
       	int[][] intervals = intervalList.toArray(new int[intervalList.size()][]);
        int prev=0;
        int curr = 1;
        while(curr<intervals.length) {
            if(intervals[prev][1]>=intervals[curr][0]) {
                intervals[prev][1]=Math.max(intervals[curr][1], intervals[prev][1]);
            } else {
                intervals[++prev]=intervals[curr];
            }
            curr++;
        }
        return Arrays.copyOf(intervals, prev+1);
    }
}