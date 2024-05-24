import java.util.*;

class MyCalendarTwo {
    public static void main(String args[]) {
        MyCalendarTwo cal = new MyCalendarTwo();
        System.out.println(cal.book(10, 20));
        System.out.println(cal.book(50, 60));
        System.out.println(cal.book(10, 40));
        System.out.println(cal.book(5, 15));
        System.out.println(cal.book(5, 10));
        System.out.println(cal.book(25, 55));
    }

    List<int[]> intervals;
    Map<Integer, Boolean> overlapFlagMap;
    public MyCalendarTwo() {
        intervals = new ArrayList<>();
        overlapFlagMap = new HashMap<>();
    }
    
    public boolean book(int start, int end) {
        System.out.print(start+","+end+"==");
        int pos = searchPos(start, end);
        if(pos==-1) return false;

        if(intervals.size()==0 || !isOverlapping(intervals.get(pos==intervals.size() ? pos - 1 : pos), start, end)) {
            intervals.add(pos, new int[]{start, end});
            overlapFlagMap.put(start, false);
        } else {
            pos--;
            int[] temp = intervals.get(pos);
            overlapFlagMap.remove(temp[0]);
            temp[0] = Math.min(temp[0], start);
            temp[1] = Math.max(temp[1], end);
            overlapFlagMap.put(temp[0], true);
        }

        for(int[] curr: intervals) {
            System.out.print("("+curr[0]+","+curr[1]+")"+"->");
        }
        System.out.print("position = "+pos+"[overlap="+overlapFlagMap.get(start)+"]");
        return true;
    }

    public int searchPos(int start, int end) {
        int left=0;
        int right=intervals.size()-1;
        while(left<=right) {
            int mid = (left+right)/2;
            int[] curr = intervals.get(mid);
            if(isOverlapping(curr, start, end) && overlapFlagMap.get(curr[0])) {
                return -1;
            } else if(end<=curr[0]){
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return left;
    }

    public boolean isOverlapping(int[] curr, int start, int end) {
        return Math.min(end, curr[1]) > Math.max(start, curr[0]);
    }
}