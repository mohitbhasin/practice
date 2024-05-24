class MaxSubArray {
	public static void main(String args[]) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(findMax(nums));
	}
	// not efficient O(n square)
	public static int findMax(int[] nums) {
		int max = Integer.MIN_VALUE;

		for(int i=0; i<nums.length; i++) {
			int currSum = 0;
			for(int j=i; j<nums.length; j++) {
				currSum+=nums[j];
				if(currSum>max) {
					max=currSum;
				}
			}		
		}
		return max;
	}
}