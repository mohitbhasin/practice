class MissingElementInSorted {
	public static void main(String args[]) {
		int[] nums = {4,7,9,10};
		// int[] nums = {1,2,4};
		int k = 3;
		System.out.println(missingElement(nums, k));
	}

	public static int missingElement(int[] nums, int k) {
        int result = nums[0];
        int index=1;
        while(index<nums.length && k>0) {
            if(result+1==nums[index]) {
                index++;
            } else {
            	k--;
            }
            result++;
        }

        if(k>0) result+=k;
        return result;
    }
}