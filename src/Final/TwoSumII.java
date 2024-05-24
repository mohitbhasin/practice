import java.util.*;

class TwoSumII {
	public static void main(String args[]) {
		int[] numbers = {2,7,11,15};
		for(int n: twoSum(numbers, 13)) {
			System.out.print(n+", ");
		}
	}

	public static int[] twoSum(int[] numbers, int target) {
		
		int[] result = new int[2];

		int low=0;
		int high=numbers.length-1;
		while(low<high) {
			int sum = numbers[low]+numbers[high];
			if(sum==target) {
				result[0]=low+1;
				result[1]=high+1;
				return result;
			}
			if(sum>target) {
				high--;
			} else {
				low++;
			}
		}
		result[0]=-1;
		result[1]=-1;

		return result;
    }
}