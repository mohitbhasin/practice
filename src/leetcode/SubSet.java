import java.util.*;

class SubSet {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(generateSubset(nums));
	}

	public static List<List<Integer>> generateSubset(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(0, nums, list, result);
		return result;
	}

	public static void helper(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(list));
		for(int i=index; i<nums.length; i++) {
			list.add(nums[i]);
			helper(i+1, nums, list, result);
			list.remove(list.size() - 1);
		}
	}
}