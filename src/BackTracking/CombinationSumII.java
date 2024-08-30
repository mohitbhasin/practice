import java.util.*;


class CombinationSumII {
	public static void main(String args[]) {
		// int[] candidates = {10,1,2,7,6,1,5};
        // int target = 8;
		// int[] candidates = {2,5,2,1,2};
        // int target = 5;
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int target = 30;
		System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
    	backtrack(candidates, 0, 0, target, new ArrayList<>(), result);
    	return result;
    }
    
    public static void backtrack(int[] candidates, int index, int sum, int target, List<Integer> list, List<List<Integer>> result) {
        if(sum==target) {
    		result.add(new ArrayList<>(list));
    	}
    	if(sum>=target) return;
        int prev = -1;
        for(int i=index; i<candidates.length; i++) {
            if(candidates[i]==prev) continue;
            list.add(candidates[i]);
            backtrack(candidates, i+1, sum+candidates[i], target, list, result);
            list.remove(list.size()-1);
            prev = candidates[i];
        }
    }
}