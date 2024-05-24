import java.util.*;
//incorrect
class CombinationSum {
	public static void main(String args[]) {
		int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5};
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combination(candidates, 0, 8, new ArrayList<Integer>(), result);
		System.out.println(result);
	}

	public static void combination(int[] candidates, int index, int target, ArrayList<Integer> curr, List<List<Integer>> result) {
		if(target==0) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}
		if(target<0) {
			index++;
			return;
		}
		curr.add(candidates[index]);
		combination(candidates, index, target-candidates[index], curr, result);
		curr.remove(curr.length()-1);
	}
}