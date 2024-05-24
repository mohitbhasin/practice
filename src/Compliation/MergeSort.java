class MergeSort {
	public static void main(String args[]) {
		int[] nums = {3,1,5,4,45,22,4,-1,10};
		sort(nums, 0, nums.length-1);
		for(int num: nums)
		System.out.print(num+" ");
	}

	public static void sort(int[] nums, int left, int right) {
		int mid=(left+right)/2;
		if(left==mid) {
			return;
		}
		sort(nums, left, mid-1);
		sort(nums, mid, right);
		merge(nums, left, right, mid);
	}

	public static void merge(int[] nums, int left, int right, int mid) {
		for(int i=0; i<=mid; i++) {
			for(int j=mid; j<=right; j++) {
				if(nums[i]>nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}	
		}
	}
}