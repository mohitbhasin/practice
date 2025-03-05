class FindTheDuplicateNumber {
	// array contains [1, n] (inclusive)
	public static void main(String args[]) {
		int[][] numsArr = {
			{1,3,4,2,2},
			{3,1,3,4,2},
			{3,3,3,3,3}
		};
		for(int[] nums: numsArr) System.out.println(findTheDuplicate_slowFast(nums));
		System.out.println("-----------");
		for(int[] nums: numsArr) System.out.println(findDuplicate_negativeMarking(nums));
	}

	// Fast and slow pointer approach jumping on indexes from values.
	// This is acceptable approach as array is not modified.
	public static int findTheDuplicate_slowFast(int[] nums) {
		int slow = nums[0];
  		int fast = nums[0];
  		while(true) {
  			slow=nums[slow];
  			fast=nums[nums[fast]];
            if(slow==fast) break;
  		}

  		slow = nums[0];
  		while(slow!=fast) {
  			slow = nums[slow];
  			fast = nums[fast];
  		}
  		return slow;

	}

	// This approach modifies the array, which is not allowed in some questions.
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