import java.util.*;

class Combinations {
	public static void main(String args[]) {
		List<List<Integer>> result = new ArrayList<>();
		int n=5;
		int k=2;
		helper(n, 1, k, new ArrayList<Integer>(), result);
		System.out.println(result);

	}

	public static void helper(int n, int curr, int k, List<Integer> comb, List<List<Integer>> result) {
        if(comb.size()==k) {
            result.add(new ArrayList<>(comb));
        }
        for(int i=curr; i<=n; i++) {
            comb.add(i);
            helper(n, i+1, k, comb, result);
            comb.remove(comb.size()-1);
        }
    }
}