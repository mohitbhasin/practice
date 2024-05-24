class BubbleSort {
	public static void main(String args[]) {
		
		int[] nums = {4,23,1,15,6,45,3,6,89};
		sort(nums);
		for(int i: nums) {
			System.out.print(i+" ");
		}
	}

	public static void sort(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			for(int j=i; j<nums.length; j++) {
				if(nums[i]>nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}		
		}
	}
}