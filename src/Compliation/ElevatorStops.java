import java.util.*;
//Not correct solution
class ElevatorStops {
	public static void main(String args[]) {
		// int[] A = {60, 80, 40};
		// int[] B = {2, 3, 5};
		// int M = 5;
		// int X = 2;
		// int Y = 200;
		int[] A = {40, 40, 100, 80, 20};
		int[] B = {3, 3, 2, 2, 3};
		int M = 3;
		int X = 5;
		int Y = 200;

		System.out.println(solution(A, B, M, X, Y));
	}

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		int start=0;
		int index=0;

		int people=0;
		int weight=0;

		int count=0;

		while(index<A.length) {
			if(weight+A[index]>Y || people==X || index==A.length-1) {
				if(index==start) index++;
				count+=countSteps(B, start, index);
				start=index;
				weight=0;
				people=0;
			} else {
				weight+=A[index];
				people++;
				index++;
			}
		}
		return count;
	}

	public static int countSteps(int[] B, int start, int end) {
		Set<Integer> set = new HashSet<Integer>();
		// if(start==end)
		for(int i=start; i<end; i++) {
			set.add(B[i]);
		}
		System.out.println(set);
		return set.size() + 1;
	}
}