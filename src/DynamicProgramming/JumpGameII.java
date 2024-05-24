import java.util.*;

class JumpGameII {
	public static void main(String args[]) {
		// int[] nums = {1,2,1,1,1};
		// int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		int[] nums = {2,3,1,1,4};
		// System.out.println(jump(nums));
		System.out.println(jump_linear(nums));
	}

// without memoization
	public static int jump(int[] nums) {
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

    public static int jump_linear(int[] nums) {
    	int far = 0;
    	int left = 0;
    	int result=0;
    	List<Integer> list = new ArrayList<>();
    	for(int i=0; i<nums.length-1; i++) {
    		far = Math.max(far, i+nums[i]);
    		if(left==i) {
    			list.add(left);
    			left = far;
    			result++;
    		}
    		System.out.println(left);
    	}
    	System.out.println(list);
    	return result;
    }
}