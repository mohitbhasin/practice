class NextPermutation {
	public static void main(String args[]) {
		// int[] nums = {1,2,3};
		// int[] nums = {3,2,1};
		// int[] nums = {1,1,5};
		int[] nums = {1,2,3,6,4,2,0};

		nextPermutation(nums);

		for(int num: nums) System.out.print(num+", ");
	}

	public static void nextPermutation(int[] nums) {
        int pivot=-1;
        int n = nums.length-1;
        
        for(int i=n-1; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                pivot=i;
                break;
            }
        }
        
        if(pivot==-1) {
            for(int i=0; i<nums.length/2; i++){
                swap(nums, i, n-i);
            }
            return;
        }
        for(int i=n; i>pivot; i--) {
            if(nums[i]>nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }
        int left = pivot + 1;
        int right = n;
        while(left<right) {
            swap(nums, left++, right--);
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}