import java.util.*;

class Permutations {
	public static void main(String args[]) {
		System.out.println(permute(new int[]{1,2,3}));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		for(int n: nums) {
			curr.add(n);
		}
		helper(nums, nums.length, curr, output, 0);
		return output;
	}

	public static void helper(int[] nums, int n, List<Integer> curr, List<List<Integer>> output, int index) {
		if(index==n) {
			output.add(new ArrayList<>(curr));
		}

		for(int i=index; i<n; i++) {
			Collections.swap(curr, index, i);
			helper(nums, n, curr, output, index+1);
			Collections.swap(curr, index, i);
		}
	}
}