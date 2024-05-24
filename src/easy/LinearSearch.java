class LinearSearch {
	public static void main(String args[]) {
		System.out.println(search(new int[]{2,3,4,5,6,0,1}));
		System.out.println(search(new int[]{2,3,4,5,6,0,1,2}));
		System.out.println(search(new int[]{1,2,3,4,5,6,0x}));
	}

	public static int search(int[] nums) {
		int prev = 0;
		int curr =1;
		int val = nums[0];

		while(curr<nums.length) {
			if(nums[prev]>nums[curr]) {
				val = nums[curr];
				break;
			}
			prev++;
			curr++;
		}
		return val;
	}
}