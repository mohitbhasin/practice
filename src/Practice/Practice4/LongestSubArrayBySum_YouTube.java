class LongestSubArrayBySum_YouTube {
	public static void main(String args[]) {
		sumSubArray(new int[]{1,2,3,7,5}, 15);
	}

	public static int[] sumSubArray(int[] nums, int sum) {
		int start=0;
		int end=0;
		int[] result=new int[2];
		int temp=0;

		while(end<nums.length) {

			if(temp<sum) {
				temp+=nums[end++];
				System.out.println("if "+temp);
			} else if(temp>sum) {
				temp-=nums[start++];
				System.out.println("else if "+temp);
			} else {
				if((end - start) > (result[1] - result[0])) {
					result[0]=start;
					result[1]=end++;
				}
				System.out.println("else "+temp);
			}
		}
		System.out.println(result[0]+", "+result[1]);
		return result;
	}
}