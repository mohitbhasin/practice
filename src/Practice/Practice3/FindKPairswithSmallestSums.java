import java.util.*;
class FindKPairswithSmallestSums {
	public static void main(String args[]) {
		int[] num1 = {1, 7, 11};
		int[] num2 = {2, 4, 6};
		System.out.println(returnKPairs(num1, num2, 3));
	}

	public static List<List<Integer>> returnKPairs(int[] num1, int[] num2, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> pair;


		for(int i=0; i<num1.length; i++) {
			for(int j=0; j<num2.length; j++) {
				pair = new ArrayList<Integer>();
				pair.add(num1[i]);
				pair.add(num2[j]);
				result.add(pair);
			}
		}

		Comparator<List<Integer>> comp = new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return (o1.get(0) + o1.get(1)) - (o2.get(0) + o2.get(1)); 
			}
		};

		Collections.sort(result, comp);
		return result.subList(0, k);
	}
}