class HasPairWithSum {
	public static void main(String args[]) {
		int[] nums = {1,2,4,4};
		System.out.println(hasPair(nums, 5));
	}

	public static boolean hasPair(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while(low < high) {
			int s = nums[low] + nums[high];
			if(s==target) {
				return true;
			}
			if(s<target) {
				low++;
			} else {
				high--;
			}
		}

		return false;
	}
}