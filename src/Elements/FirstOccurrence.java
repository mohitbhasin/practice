class FirstOccurrence {
	public static void main(String args[]) {
		int[] nums = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		System.out.println(search(nums, 108));
	}

	public static int search(int[] nums, int num) {
		int left=0;
		int right=nums.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(nums[mid]!=num && nums[mid+1]==num) {
				return mid+1;
			}
			else if(num<=nums[mid]) {
				right=mid;
			}
			else {
				left=mid;
			}
		}
		return -1;
	}
}