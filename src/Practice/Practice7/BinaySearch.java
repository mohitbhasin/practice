class BinaySearch {
	public static void main(String args[]) {
		int[] nums = {1,2,3,4,5,6,7};
		System.out.println(searchIndex(nums, 1));
	}

	public static int searchIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while(left<right) {
			int mid = (left + right)/2;

			if(nums[mid]==target) {
				return mid;
			}
			if(nums[mid]>target) {
				right=mid-1;
			} else {
				left = mid+1;
			}
		}
		return -1;
	}
}