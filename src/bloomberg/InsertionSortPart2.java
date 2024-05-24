class InsertionSortPart2 {
	public static void main(String args[]) {
		// int nums[] = {3,1,5,4,2};
		int nums[] = {3,4,7,5,6,2,1};
		sort(nums);
	}
	// this is more 
	public static void sort(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			print(nums);
			for(int j=0; j<nums.length-1; j++) {
				if(nums[j]>nums[j+1]) {
					int temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	public static void print(int nums[]) {
		for(int n: nums) {
			System.out.print(n+" ");
		}
		System.out.println();
	}
}