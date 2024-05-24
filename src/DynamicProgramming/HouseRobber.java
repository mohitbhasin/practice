import java.util.*;

class HouseRobber {
	public static void main(String args[]) {
		// int[] nums = {2,7,9,3,1};
		int[] nums = {2,1,9,12};
		memo = new int[nums.length];
		System.out.println(dp(nums, nums.length-1));
		System.out.println(dp_bottomUp(nums));
		// for(int i: memo) {
		// 	System.out.print(i+", ");
		// }
	}
	static int[] memo;
	public static int dp(int[] nums, int i) {
		if(i==0) return nums[i];
		if(i==1) return Math.max(nums[0], nums[1]);
		memo[i] = Math.max(nums[i]+dp(nums, i-2), dp(nums, i-1));

		return memo[i];
	}

	public static int dp_bottomUp(int[] nums) {
		if(nums.length==1) return nums[0];
		int[] memo = new int[nums.length];
		memo[0]=nums[0];
		memo[1]=Math.max(nums[1],nums[0]);
		for(int i=2; i<nums.length; i++) {
			memo[i]=Math.max(memo[i-1], memo[i-2]+nums[i]);
		}

		return memo[nums.length-1];
	}
}