class RemoveDuplicatesFromSortedArrayII {
	public static void main(String args[]) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		int k = removeDuplicates(nums);
		for(int i=0; i<k; i++) {
			System.out.print(nums[i]+", ");
		}
	}

	public static int removeDuplicates(int[] nums) {
        int count = 1;
        int prev = 1;
        int curr = 1;

        while(curr<nums.length) {
            if(nums[curr]==nums[curr-1]) {
                count++;
            } else {
                count=1;
            }
            System.out.println(nums[curr]+": "+count);
            if(count<=2){
                nums[prev++]=nums[curr];
            }
            curr++;
        }
        return prev;
    }
}