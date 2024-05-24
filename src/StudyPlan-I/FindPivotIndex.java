import java.util.*;

class FindPivotIndex {
	public static void main(String[] args) {
		// int[] nums = {1,7,3,6,5,6};
		// int[] nums = {-1,-1,-1,-1,-1,-1};
		int[] nums = {-1,-1,0,1,1,0};
 		System.out.println(pivotIndex(nums));
	}
	public static int pivotIndex(int[] nums) {
        int[] cumSum = new int[nums.length+1];
        int prev = 0;
        for(int i=nums.length - 1; i>=0; i--) {
            prev+=nums[i];
            cumSum[i]=prev;
        }

        prev=0;
        for(int i=0; i<nums.length; i++) {
            if(prev==cumSum[i+1]) {
                return i;
            }
            prev+=nums[i];
        }
        return -1;
    }

    public static int pivotIndex_withoutArray(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for(int num: nums) {
            sum+=num;
        }

        for(int i=0; i<nums.length; i++) {
            int rightSum = sum - leftSum - nums[i];
            if(rightSum==leftSum) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

	// Advanced
    public int pivotIndex_withoutArray_advanced(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}