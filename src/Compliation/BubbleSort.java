class BubbleSort {
	public static void main(String args[]) {
		int[] nums = {5,8,1,21,7,44,15,0};
		sort(nums);
		for(int n: nums) {
			System.out.print(n+"\t");
		}
	}

	static void sort(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i]>nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
}