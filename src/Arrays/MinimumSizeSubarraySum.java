class MinimumSizeSubarraySum {
	public static void main(String args[]) {
		int[][] nums = {{2,3,1,2,4,3}, {1,4,4}, {1,1,1,1,1,1,1,1}};
		int[] target = {7,4,11};

		for(int i=0; i<nums.length; i++) {
			System.out.println(minSubArrayLen(target[i], nums[i]));
		}
	}

	public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        
        while(left<nums.length || right<nums.length) {
            if(right<nums.length && sum<target) {
                sum+=nums[right++];
            } else {
                if(sum<target) {
                    left++;
                    continue;
                }
                minLen = Math.min(minLen, right - left);
                sum-=nums[left++];
            }
        }
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}