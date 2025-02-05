class FindTheDuplicateNumber {
	public static void main(String args[]) {
		int[][] numsArr = {
			{1,3,4,2,2},
			{3,1,3,4,2},
			{3,3,3,3,3}
		};
		for(int[] nums: numsArr) System.out.println(findTheDuplicate_slowFast(nums));
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
}