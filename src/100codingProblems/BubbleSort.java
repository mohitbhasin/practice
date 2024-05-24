class BubbleSort {
	public static void main(String args[]) {
		int[] nums = {3,1,5,4,45,22,4,-1,10};
		sort(nums);
		for(int num: nums)
		System.out.print(num+" ");
	}

	public static void sort(int[] nums) {
		int len = nums.length;
		for(int i=0; i<len; i++) {
			for(int j=i; j<len; j++) {
				if(nums[i]>nums[j])
					swap(nums, i, j);
			}
		}
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}