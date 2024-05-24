class FindMinimumInRotatedSortedArray {
	public static void main(String args[]) {
		int[] nums = {3,4,5,1};
        System.out.println(findMin(new int[]{2,3,4,5,6,0,1}));
        System.out.println(findMin(new int[]{2,3,4,5,6,0,1,2}));
        System.out.println(findMin(new int[]{1,2,3,4,5,6,0}));
        System.out.println(findMin(new int[]{6,0,1,2,3,4,5,6}));
        System.out.println(findMin(new int[]{0,1,2,3,4,5,6}));
		System.out.println(findMin(nums));
	}

	public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid = (left + right) / 2;
            if(nums[mid]<nums[right]) {
                right=mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}