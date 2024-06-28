import java.util.*;

class SplitArrayLargestSum {
	public static void main(String args[]) {
		List<int[]> numsList = Arrays.asList(
			new int[]{1,4,4}, 
			new int[]{7,2,5,10,8}, 
			new int[]{1,2,3,4,5}, 
			new int[]{1,2,3,4,5});
		List<Integer> kList=Arrays.asList(3, 2, 2, 1);
		
		for(int i=0; i<numsList.size(); i++) System.out.println(splitArray(numsList.get(i), kList.get(i)));
	}

	public static int splitArray(int[] nums, int k) {
        int sum = 0;
		int maxVal = 0;
		for(int num: nums) {
			sum+=num;
			maxVal=Math.max(num, maxVal);
		}
		int left = maxVal;
		int right = sum;
		int result = 0;
		while(left<=right) {
			int mid = left + (right - left) / 2;
			int numSubArr = minSubArrayRequired(nums, mid);
			// getting more splits than required. increase the sum to reduce number of splits.
			if(numSubArr>k) {
				left=mid+1;
			} else { // splits are less than or equal to k, decrease sum to find minimized max sum.
				result = mid;
				right=mid-1;
			}
		}
		return result;

	}

	public static int minSubArrayRequired(int[] nums, int maxSubArraySumAllowed) {
		int splitsRequired = 0;
		int sum=0;
		for(int num: nums) {
			if(sum+num>maxSubArraySumAllowed) {
				splitsRequired++;
				sum=num;
			} else {
				sum+=num;
			}
		}
		return splitsRequired+1;
	}
}