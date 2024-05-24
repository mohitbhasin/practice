import java.util.*;

class CodePatterns {
	public static void main(String args[]) {
		int[] nums = {1,2,3};
		System.out.println(subsets_backtracking(nums));
        System.out.println(subsets_twoCalls(nums));
	}




	static List<List<Integer>> result;
    public static List<List<Integer>> subsets_backtracking(int[] nums) {
        result = new ArrayList<>();
        subsets_backtracking(nums, 0, new ArrayList<>());
        return result;
    }

    public static List<List<Integer>> subsets_twoCalls(int[] nums) {
        result = new ArrayList<>();
        helper_twoCalls(nums, 0, new ArrayList<>());
        return result;
    }
    

    public static void helper_twoCalls(int[] nums, int index, List<Integer> list) {
        if(index==nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        List<Integer> newList = new ArrayList<>(list);
        list.add(nums[index]);
        helper_twoCalls(nums, index+1, list);
        helper_twoCalls(nums, index+1, newList);
    }

    public static void subsets_backtracking(int[] nums, int index, List<Integer> list) {
    	result.add(new ArrayList<>(list));
    	for(int i=index; i<nums.length; i++) {
    		list.add(nums[i]);
    		subsets_backtracking(nums, i+1, list);
    		list.remove(list.size()-1);
    	}
    }
}