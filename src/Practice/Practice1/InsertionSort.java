class InsertionSort {
	public static void main(String args[]) {
		int[] nums = {17,25,31,13,2};
		sort(nums);
		for(int num: nums) {
			System.out.print(num+" ");
		}
	}

	public static int[] sort(int[] nums) {
		for(int j=1; j<nums.length; j++) {
			int i=j-1;
			if(nums[i]>nums[j]) {
				swap(nums, i, j);
			}
		}
		return nums;
	}

	public static void swap(int[] nums, int i, int j) {
		while(nums[i]>nums[j]) {
			int temp=nums[i];
			nums[i]=nums[j];
			nums[j]=temp;
			i--;
			j--;
			if(i<0) return;
		}
	}
}