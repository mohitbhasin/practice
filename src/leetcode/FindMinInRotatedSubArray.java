class FindMinInRotatedSubArray {
	public static void main(String args[]) {
		System.out.println(search(new int[]{2,3,4,5,6,0,1}));
		System.out.println(search(new int[]{2,3,4,5,6,0,1,2}));
		System.out.println(search(new int[]{1,2,3,4,5,6,0}));
		System.out.println(search(new int[]{6,0,1,2,3,4,5,6}));
		System.out.println(search(new int[]{0,1,2,3,4,5,6}));
	}

	public static int search(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		if(nums.length==1) return nums[0];
		if(nums[right]>nums[left]) {
			return nums[0];
		}
		while(left<right) {
			int mid = (left + right)/2;
			if(nums[mid]>nums[mid+1]) {
				return nums[mid+1];
			}
			if(nums[mid-1]>nums[mid]) {
				return nums[mid];
			}
			if(nums[mid]>nums[0]) {
				left=mid+1;
			} else {
				right=mid-1;
			}
		}
		return -1;
	}
}