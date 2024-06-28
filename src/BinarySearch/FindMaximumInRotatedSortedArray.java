// not the problem online. need to run more test cases.
class FindMaximumInRotatedSortedArray {
	public static void main(String args[]) {
        System.out.println(findMax(new int[]{17,15,13,11,10}));
        System.out.println(findMax(new int[]{2,1,0,6,5,4,3}));
        System.out.println(findMax(new int[]{4,3,2,1,0,6,5}));
        int[] nums = {3,1,5,4};
		System.out.println(findMax(nums));
	}

	public static int findMax(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]<nums[right]) {
                left=mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}