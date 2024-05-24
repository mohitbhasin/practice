class HouseRobber {
	public static void main(String args[]) {
		// int[] nums = {2,7,9,3,1};
		int[] nums = {2,1,1,2};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
        int max = 0;
        return helper(nums, 0, 0, new int[nums.length]);
    }
    
    public static int helper(int[] nums, int index, int sum, int[] memo) {
        if(index>=nums.length) {
            return sum;
        }
        if(memo[index]>0) {
        	return memo[index];
        }
        int ans = Math.max(helper(nums, index+1, sum+nums[index], memo), helper(nums, index+2, sum+nums[index], memo) + nums[index]);
        return memo[index];
    }

}