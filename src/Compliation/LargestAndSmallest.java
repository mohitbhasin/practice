class LargestAndSmallest {
	public static void main(String args[]) {
		int[] nums = {5,8,1,21,5,15,7,44,15,0,1,21,21,5};
		find(nums);
	}

	public static void find(int[] nums) {
		int small=Integer.MAX_VALUE;
		int large=Integer.MIN_VALUE;

		for(int n: nums) {
			if(n>large) large=n;
			if(n<small) small=n;
		}

		System.out.println("Smallest = "+ small);
		System.out.println("Largest = "+ large);
	}
}