class TargetSum {
	public static void main(String args[]) {
		int[] nums = {1,1,1,1,1};
		int target = 3;

		System.out.println(findTargetSumWays(nums, target));
	}

	public static int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
    
    public static int helper(int[] nums, int target, int currVal, int index) {
        if(index==nums.length && currVal==target) {
            return 1;
        }
        if(index>=nums.length) {
            return 0;
        }
        int result = 0;
        result+=helper(nums, target, currVal+nums[index], index+1);
        result+=helper(nums, target, currVal-nums[index], index+1);
        return result;
    }
}