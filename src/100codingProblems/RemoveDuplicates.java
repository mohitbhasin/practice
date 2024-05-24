import java.util.*;

class RemoveDuplicates {
	public static void main(String args[]) {
		int[] nums = {2, 5, 5, 6, 1, 2};
		for(int n: removeDup(nums)) {
			System.out.print(" "+n);
		}
	}

	public static int[] removeDup(int[] nums) {
		int pre=0;
		int curr=0;
		Set<Integer> set = new HashSet<Integer>();

		while(curr<nums.length) {
			if(!set.contains(nums[curr])) {
				set.add(nums[curr]);
				nums[pre]=nums[curr];
				pre++;
			}
			nums[pre]=nums[curr++];
		}

		return Arrays.copyOf(nums, pre);
	}