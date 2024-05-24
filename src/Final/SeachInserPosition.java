class SeachInserPosition {
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		System.out.println(search(nums, 7));
	}

	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		int mid = -1;
		while(start<=end) {
			System.out.println(start+"---"+end);
			mid = start + (end - start) / 2;
			if(nums[mid]==target) {
				return mid;
			}
			if(nums[mid]<target) {
				start=mid+1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}
}