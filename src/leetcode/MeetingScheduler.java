import java.util.*;

class MeetingScheduler {
	public static void main(String[] args) {
		// int[][] slots1 = {{10,50},{60,120},{140,210}}; 
		// int[][] slots2 = {{0,15},{60,70}}; 
		// int duration = 8;
		int[][] slots1 = {{216397070,363167701},{98730764,158208909},{441003187,466254040},{558239978,678368334},{683942980,717766451}};
		int[][] slots2 = {{50490609,222653186},{512711631,670791418},{730229023,802410205},{812553104,891266775},{230032010,399152578}};

		int duration = 456085;
		System.out.println(scheduler(slots1, slots2, duration));
	}

	public static List<Integer> scheduler(int[][] slots1, int[][] slots2, int duration) {
		int i=0;
		int j=0;
		int start;
		int end;
		List<Integer> result = new ArrayList<>();
		while(i<slots1.length && j<slots2.length) {
			start = Math.max(slots1[i][0], slots2[j][0]);
			end = Math.min(slots1[i][1], slots2[j][1]);
			if(duration<=end-start) {
				result.add(start);
				result.add(start+duration);
				return result;
			}
			if(slots1[i][1]>slots2[j][1]) {
				j++;
			} else {
				i++;
			}
		}
		return result;
	}
}