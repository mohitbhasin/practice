import java.util.*;

class NextClosestTime {
	public static void main(String args[]) {
		String[] times = {"19:34", "23:59", "00:00"};
		for(String time: times) {
			System.out.println(nextClosestTime(time));
		}
	}

	public static String nextClosestTime(String time) {
        int minutes = Integer.parseInt(time.substring(0,2)) * 60;
        minutes+=Integer.parseInt(time.substring(3));
        Set<Integer> set = new HashSet<>();
        set.add(time.charAt(0)-'0');
        set.add(time.charAt(1)-'0');
        set.add(time.charAt(3)-'0');
        set.add(time.charAt(4)-'0');
        
        while(true) {
            minutes=(minutes+1) % (24*60);
            
            int[] pair = {minutes/60/10, (minutes/60)%10, minutes%60/10, minutes%60%10};
            boolean flag = true;
            for(int curr: pair) {
                if(!set.contains(curr)) {
                    flag=false;
                    break;
                }
            }
            if(flag) {
                return ""+pair[0]+pair[1]+":"+pair[2]+pair[3];
            }
        }
    }
}