import java.util.*;

class OptimalTime {
	public static void main(String args[]) {
		int[] times = {30,15,60,75,45,15,15,45};

		// System.out.println(Math.max(computeTime(times, 0, 0), computeTime(times, 1, 0)));
		System.out.println(computeTime2(times, 0, new int[times.length]));
	}

	public static int computeTime(int[] times, int index, int result) {
		if(index>=times.length) {
			return result;
		}

		int result1 = computeTime(times, index+2, times[index]+result);
		int result2 = computeTime(times, index+3, times[index]+result);

		return Math.max(result1, result2);
	} 

	public static int computeTime2(int[] times, int index, int[] memo) {
		if(index>=times.length) {
			return 0;
		}
		int result1 = times[index] + computeTime2(times, index+2, memo);
		int result2 = computeTime2(times, index+1, memo);

		memo[index]=Math.max(result1, result2);

		return memo[index];
	} 
}