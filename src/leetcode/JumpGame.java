class JumpGame {
	public static void main(String args[]) {
		int[] nums = {3,2,1,0,4};
		System.out.println(jump(nums, 0));
	}

	public static boolean jump(int[] nums, int index) {
		if(index>=nums.length) {
			return true;
		}

		int val = nums[index];
		boolean flag = false;
		for(int i=1; i<=val; i++) {
			flag = jump(nums, index+i);
		}

		return flag;
	}
}