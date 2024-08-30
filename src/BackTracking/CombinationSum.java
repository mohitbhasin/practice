import java.util.*;

class CombinationSum {
	public static void main(String args[]) {
		int[] candidates = {2,3,6,7};
        int target = 7;
		// int[] candidates = {2,3,5};
        // int target = 8;
        System.out.println(combinationSum(candidates, target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        helper(result, 0, candidates, target, 0, new ArrayList<>());
        
        return result;
    }
    
    public static void helper(List<List<Integer>> result, int index, int[] candidates, int target, int sum, List<Integer> curr) {
        if(sum==target) {
            result.add(new ArrayList<Integer>(curr));
        }
        
        if(sum>target) {
            return;
        }
        
        for(int i=index; i<candidates.length; i++) {
            int num = candidates[i];
            curr.add(num);
            helper(result, i, candidates, target, sum+num, curr);
            curr.remove(curr.size()-1);
        }
    }
}