class FindMinimumInRotatedSortedArray {
	public static void main(String args[]) {
		int[] nums = {3,4,5,1};
        System.out.println(findMin(new int[]{2,3,4,5,6,0,1}));
        System.out.println(findMin(new int[]{2,3,4,5,6,0,1,2}));
        System.out.println(findMin(new int[]{1,2,3,4,5,6,0}));
        System.out.println(findMin(new int[]{6,0,1,2,3,4,5,6}));
        System.out.println(findMin(new int[]{0,1,2,3,4,5,6}));
		System.out.println(findMin(nums));
        System.out.println(findMin_alternate(new int[]{2,3,4,5,6,0,1}));
        System.out.println(findMin_alternate(new int[]{2,3,4,5,6,0,1,2}));
        System.out.println(findMin_alternate(new int[]{1,2,3,4,5,6,0}));
        System.out.println(findMin_alternate(new int[]{6,0,1,2,3,4,5,6}));
        System.out.println(findMin_alternate(new int[]{0,1,2,3,4,5,6}));
        System.out.println(findMin_alternate(nums));
	}

    // template 2
	public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid = (left + right) / 2;
            // it means the array is not rotated from mid to right, search more smaller element in the left.
            if(nums[mid]<nums[right]) {
                right=mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
    // template 2
    public static int findMin_alternate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid = (left + right) / 2;
            // it means the array is rotated from mid tp right, search smaller element on the right.
            if(nums[mid]>nums[right]) {
                left=mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}