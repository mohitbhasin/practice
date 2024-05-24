class SubarraySumEqualsK {
	public static void main(String args[]) {
		System.out.println(countPossibilities(new int[]{1,1,1}, 2));
	}

	public static int countPossibilities(int[] nums, int k) {
		int result = 0;
		for(int i=0; i<nums.length; i++) {
			int sum=0;
			for(int j=i; j<nums.length; j++) {
				sum+=nums[j];
				if(sum==k) {
					result++;
					break;
				}
				if(sum>k) {
					break;
				}
			}
		}
		return result;
	}
}