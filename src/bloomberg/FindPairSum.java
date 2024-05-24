import java.util.*;

class FindPairSum {
	public static void main(String args[]) {
		// int[] nums = {3, 8, 1, 4, 7, 6};
		int[] nums = {1, 4, 5, 3, 2};
		System.out.println(findPair(nums, 4));
	}

	public static List<List<Integer>> findPair(int[] nums, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> pair;
		Set<Integer> set = new HashSet<>();
		for(int n: nums) {
			int comp = k-n;
			set.add(comp);
			if(set.contains(n)) {
				pair = new ArrayList<>();
				pair.add(comp);
				pair.add(n);
				result.add(pair);
			}
		}
		return result;
	}
}