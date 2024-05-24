import java.util.*;
class InsertInterval {
	public static void main(String args[]) {
		// int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		// int[] newInterval = {4,8};
        int[][] intervals = {{1,5}};
        int[] newInterval = {2,7};
        int[][] result = insert(intervals, newInterval);
        for(int[] interval: result) {
            System.out.print("["+interval[0]+", "+interval[1]+"]");
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

    public static boolean isOverlapping(int[] a, int[] b) {
        return Math.min(a[1],b[1]) >= Math.max(a[0], b[0]);
    }

    public static int[] mergeInterval(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    public static int[][] insert_II(int[][] intervals, int[] newInterval) {
        List<int[]> merger = new ArrayList<>(Arrays.asList(intervals));
        for(int i=0; i<merger.size(); i++) {
            if(newInterval[0]<intervals[i][0]) {
                merger.add(i, newInterval);
                break;
            }
        }

        if(merger.size()==intervals.length) {
            merger.add(newInterval);
        }

        List<int[]> mergedList = new ArrayList<>();
        for(int i=0; i<merger.size(); i++) {
            int[] currInterval = merger.get(i);
            while(i<merger.size() && isOverlapping(currInterval, merger.get(i))) {
                currInterval = mergeInterval(currInterval, merger.get(i));
                i++;
            }
            mergedList.add(currInterval);
            i--;
        }

        return mergedList.toArray(new int[mergedList.size()][2]);
    }
}