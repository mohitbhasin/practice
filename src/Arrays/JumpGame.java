class JumpGame {
	public static void main(String args[]) {
		// int[] nums = {2,3,1,1,4};
		// int[] nums = {0,2,3};
		// int[] nums = {3,0,8,2,0,0,1};
		int[] nums = {1,1,2,2,0,1,1};
		// int[] nums = {1,1,1,0};
		System.out.println(canJump(nums));
	}


	public boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;
        for(int  i=nums.length-1; i>=0; i--) {
            if(i + nums[i] >= lastPosition) {
                lastPosition=i;
            }
        }
        return lastPosition == 0;
    }

    // wrong solution
	public static boolean canJump(int[] nums) {
    	if(nums.length==1 && nums[0]>=0) return true;
        for(int i=0; i<nums.length-1; i++) {
        	if(nums[i]==0) return false;
            for(int j=i; j<=i+nums[i]; j++) {
                if(nums[j]+i>=nums.length-1) return true;
            }
        }
        return false;
    }
    // wrong solution
    public static boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int maxIndex = 0;
        
        for(int i=0; i<nums.length-1; i++) {
            maxIndex=Math.max(maxIndex, i+nums[i]);
            if(maxIndex>=nums.length-1) return true;
        }
        System.out.println(maxIndex);
        return false;
    }
}