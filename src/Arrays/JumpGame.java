class JumpGame {
	public static void main(String args[]) {
        int[][] numsArr = {
            {1,1,2,2,0,1,1},
            {2,3,1,1,4},
            {0,2,3},
            {3,0,8,2,0,0,1},
            {1,1,1,0},
            {3,2,1,0,4}
        };
        for (int[] nums: numsArr) {
		  System.out.println(canJump(nums));
          System.out.println(canJump_leftToRight(nums));
          System.out.println("--------------");
        }
	}


	public static boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;
        for(int  i=nums.length-1; i>=0; i--) {
            if(i + nums[i] >= lastPosition) {
                lastPosition=i;
            }
        }
        return lastPosition == 0;
    }

    public static boolean canJump_leftToRight(int[] nums) {
        if(nums[0]==0 && nums.length>1) return false;
        int maxJump = nums[0]-1;
        for(int i=1; i<nums.length-1; i++) {

            maxJump = Math.max(maxJump, nums[i]);
            if(maxJump==0) return false;
            maxJump--;
        }
        return true;
    }
}