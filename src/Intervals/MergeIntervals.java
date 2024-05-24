import java.util.*;

class MergeIntervals {
	public static void main(String args[]) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		List<int[][]> list = new ArrayList<>();
		list.add(new int[][]{{1,3},{2,6},{8,10},{15,18}});
		list.add(new int[][]{{1,4},{4,5}});
		list.add(new int[][]{{1,4},{0,4}});
		list.add(new int[][]{{1,4},{2,3}});
		// int[][] result = merge(intervals);
		for(int[][] x: list) {
			int[][] result = merge2(x);
			for(int[] interval: result) {
				System.out.print("["+interval[0]+", "+interval[1]+"]");
			}
			System.out.println();
		}
	}

	// bit slow
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		LinkedList<int[]> merge = new LinkedList<>();
		for(int[] interval: intervals) {
			if(merge.isEmpty() || merge.getLast()[1]<interval[0]) {
				merge.add(interval);
			} else {
				merge.getLast()[1] = Math.max(merge.getLast()[1], interval[1]);
			}
		}
		return merge.toArray(new int[merge.size()][]);
	}

	// better
	public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i=0;
        int j=1;
        
        while(j<intervals.length) {
            if(intervals[i][1]>=intervals[j][0]) {
                intervals[i][1]=Math.max(intervals[j][1], intervals[i][1]);
            } else {
                intervals[++i]=intervals[j];
            }
            j++;
        }
        return Arrays.copyOf(intervals, i+1);
    }
}