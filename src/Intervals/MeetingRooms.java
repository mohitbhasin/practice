import java.util.*;

class MeetingRooms {
	public static void main(String args[]) {
		int[][] intervals = {{0,30},{5,10},{15,20}};
		System.out.println(canAttendMeetings(intervals));
	}

	public static boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==1) return true;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i=0; i<intervals.length - 1; i++) {
            if(intervals[i][1]>intervals[i+1][0]) {
                return false;
            }
        }
        return true;

    }
	
}