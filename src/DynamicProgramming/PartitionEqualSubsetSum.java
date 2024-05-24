import java.util.*;

class PartitionEqualSubsetSum {
	public static void main(String args[]) {
		int[] nums = {6,7,4,3};
		System.out.println(canPartition(nums));
	}

	public static boolean canPartition(int[] nums) {
        int target = 0;
        for(int num: nums) target+=num;
        if(target%2==1) return false;
        target/=2;
        Boolean[][] memo = new Boolean[nums.length+1][target+1];
        boolean result = helper(nums, target, 0, 0, memo);
        return result;
    }
    
    public static boolean helper(int[] nums, int target, int sum, int index, Boolean[][] memo) {
    	if(target==sum) return true;
        if(index>=nums.length || sum>target) return false;
        if(memo[index][sum]!=null) return memo[index][sum];
        boolean result = helper(nums, target, sum+nums[index], index+1, memo) || helper(nums, target, sum, index+1, memo);
        memo[index][sum]=result;
        return result;
    }
}