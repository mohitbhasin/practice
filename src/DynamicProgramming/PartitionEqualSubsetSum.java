import java.util.*;

class PartitionEqualSubsetSum {
	public static void main(String args[]) {
		// int[] nums = {6,7,4,3};
        // int[] nums = {100,100,100,100,100,100,100,100};
        // int[] nums = {1,5,11,5};
        // int[] nums = {58,58,38,85,44,58,1,44,33,2,85,1,33,73,85,1,58,14,77};
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
		System.out.println(canPartition(nums));
	}

	public static boolean canPartition(int[] nums) {
        int target = 0;
        for(int num: nums) target+=num;
        if(target%2==1) return false;
        target/=2;
        Boolean[][] memo = new Boolean[nums.length+1][target+1];
        // boolean result = helper(nums, target, 0, 0, memo);
        Map<String, Boolean> memoMap = new HashMap<>();
        boolean result = helper_bf(nums, target, 0, 0, memoMap);
        System.out.println(memoMap.size());
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

    public static boolean helper_bf(int[] nums, int target, int sum, int index, Map<String, Boolean> memo) {
        if(sum==target) {
            return true;
        }
        if(sum>target || index==nums.length) {
            return false;
        }
        String key = sum+"-"+index;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean result = helper_bf(nums, target, sum, index+1, memo) || helper_bf(nums, target, sum+nums[index], index+1, memo);
        memo.put(key, result);
        return result;
    }
}