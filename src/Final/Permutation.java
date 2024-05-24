import java.util.*;

class Permutation {
	public static void main(String args[]) {
		System.out.println(permute(new int[] {1,2}));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> numList = new ArrayList<>();
		for(int n: nums) {
			numList.add(n);
		}
		helper(numList, result, 0);
		return result;
	}

	public static void helper(List<Integer> numList, List<List<Integer>> result, int index) {
		if(index==numList.size()) {
			result.add(new ArrayList<>(numList));
		} 

		for(int i=index; i<numList.size(); i++) {
			Collections.swap(numList, index, i);
			helper(numList, result, index+1);
			Collections.swap(numList, index, i);
		}
	}
}