import java.util.*;

class FindPairs {
	public static void main(String args[]) {
		int[] arr = {7,9,2,4,1,3};
		System.out.println(find(arr, 10));
	}

	public static List<List<Integer>> find(int[] arr, int sum) {
		Set<Integer> set = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp;
		for(int n: arr) {
			if(set.contains(n)) {
				temp = new ArrayList<>();
				temp.add(n);
				temp.add(sum-n);
				result.add(temp);
			} else {
				set.add(sum-n);
			}
		}
		return result;
	}
}