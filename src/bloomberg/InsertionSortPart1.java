class InsertionSortPart1 {
	public static void main(String args[]) {
		int[] nums = {1,2,4,5,3};
		sort(nums);
		for(int n: nums) {
			System.out.print(n+" ");
		}
	}

	public static void sort(int[] nums) {
		if(nums.length<2) {
			return;
		}

		int i=nums.length - 2;
		while(i>=0 && nums[i]>nums[i+1]) {
			int temp = nums[i];
			nums[i] = nums[i+1];
			nums[i+1] = temp;
			i--;
		}
	}
}