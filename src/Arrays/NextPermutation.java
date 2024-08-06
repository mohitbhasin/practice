class NextPermutation {
	public static void main(String args[]) {
		// int[] nums = {1,2,3};
		// int[] nums = {3,2,1};
		// int[] nums = {1,1,5};
		// int[] nums = {1,2,3,6,4,2,0};
        int[] nums = {1,1,3,4,7,6,5,2};

		nextPermutation(nums);

		for(int num: nums) System.out.print(num+", ");
	}

	public static void nextPermutation(int[] nums) {
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                int swapIndex = nums.length-1;
                while(swapIndex>i) {
                    if(nums[swapIndex]>nums[i]) {
                        swap(nums, swapIndex, i);
                        reverse(nums, i+1);
                        return;
                    }
                    swapIndex--;
                }
            }
        }
        reverse(nums, 0);
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void reverse(int[] nums, int i) {
        int j = nums.length-1;
        while(i<j) {
            swap(nums, i++, j--);
        }
    }
}