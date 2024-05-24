import java.util.*;
class TwoSum {
	public static void main(String args[]) {
		int[] nums = {2,8,9,6,4,0};
		System.out.println(isSum(nums, 7));
	}

	public static boolean isSum(int[] nums, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		for(int n: nums) {
			if(set.contains(sum-n)) {
				return true;
			}
			set.add(n);
		}
		return false;
	}
}