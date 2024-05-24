class MoveZeros {
	public static void main(String args[]) {
		int[] nums = {0,1,0,3,12};
		// int[] nums = {0};
		move(nums);
		for(int n: nums) {
			System.out.print(n+", ");
		}
	}

	public static void move(int[] nums) {
		int prev=0;

		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=0) {
				swap(nums, prev, i);
				prev++;
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}