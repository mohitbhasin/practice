class FindTheDuplicateNumber {
	public static void main(String args[]) {
		int[][] numsArr = {
			{1,3,4,2,2},
			{3,1,3,4,2},
			{3,3,3,3,3}
		};
		for(int[] nums: numsArr) System.out.println(findDuplicate_negativeMarking(nums));
	}

	// liner approach. time complexity=O(n) space complexity=O(1)
	public static int findDuplicate_negativeMarking(int[] nums) {
		int duplicate = -1;
        for(int i: nums) {
        	i = Math.abs(i);
        	if(nums[i]<0) duplicate=i; 
        	nums[i]=-nums[i];
        }
        // restore the array
        for(int i=0; i<nums.length; i++) {
        	nums[i]=Math.abs(nums[i]);
        }
        return duplicate;
    }
}