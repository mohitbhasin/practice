import java.util.*;

class CombinationSum3 {
	public static void main(String args[]) {
		List<List<Integer>> result = new ArrayList<>();
		combinations(3, 7, 0, result, new ArrayList<Integer>(), 1);
		System.out.println(result);
	}

	public static void combinations(int k , int n, int curr, List<List<Integer>> result, List<Integer> currList, int index) {
		if(curr==n && currList.size()==k) {
			result.add(new ArrayList<Integer>(currList));
			return;
		}
		else if(curr>n || currList.size()==k) {
			return;
		}
		for(int i=index; i<10; i++) {
			currList.add(i);
			combinations(k, n, curr+i, result, currList, index + 1);
			currList.remove(currList.size()-1);
		}
	}
}
