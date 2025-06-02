import java.util.*;

class JumpGameII {
	public static void main(String args[]) {
        int[][] numsArr = {
            {1,2,1,1,1},
            {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5},
            {2,3,1,1,4}
        };
        for(int[] nums: numsArr) {
            System.out.println(jump(nums));
        }		
	}

    // Greedy apporach
    public static int jump(int[] nums) {
        int maxJump = 0;
        int count = 0;
        int prevJump = 0;

        for(int i=0; i<nums.length-1; i++) {
            maxJump = Math.max(maxJump, i+nums[i]);
            if(i==prevJump) {
                prevJump=maxJump;
                count++;
            }
        }
        return count;
    }

// without memoization - slow
	public static int jump_slow(int[] nums) {
        minJumps=Integer.MAX_VALUE;
        helper(nums, 0, 0);
        return minJumps;
    }
    static int minJumps;

    public static void helper(int[] nums, int index, int jumps) {
        if(index>=nums.length-1) {
            minJumps = Math.min(jumps, minJumps);
            return;
        }
        int jump = nums[index];
        for(int i=index+1; i<=index+jump; i++) {
            helper(nums, i, jumps+1);
        }
    }
}