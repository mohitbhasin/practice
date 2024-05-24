import java.util.*;

class FindPairSum {
	public static void main(String args[]) {
		System.out.println(findPairs(new int[] {0,1,2,3,4,5,6,7,8,9}, 7));
		System.out.println(('1'));
	}

	public static ArrayList<ArrayList<Integer>> findPairs(int[] nums, int sum) {
		ArrayList<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> pair;
		for(int num: nums) {
			int diff=sum - num;
			if(!map.containsKey(diff)) {
				map.put(num, diff);
			} else {
				pair = new ArrayList<Integer>();
				pair.add(num);
				pair.add(diff);
				pairs.add(pair);
			}
		}
		return pairs;
	}
}