import java.util.*;

class CombinationSum {
	public static void main(String args[]) {
		List<List<Integer>> result = new ArrayList<>();
		int[] nums = {1, 5, 10, 25};
		combination(nums, 15, result, 0, new ArrayList<Integer>(), 0);
		System.out.println(result);
		System.out.println(result.size());
	}

	public static void combination(int[] nums, int target, List<List<Integer>> result, int sum, List<Integer> currList, int index) {
		if(sum==target) {
			result.add(new ArrayList<>(currList));
			return;
		}

		if(sum>target) {
			return;
		}

		for(int i=index; i<nums.length; i++) {
			currList.add(nums[i]);
			combination(nums, target, result, sum + nums[i], currList, i);
			currList.remove(currList.size() - 1);
		}
	}
}