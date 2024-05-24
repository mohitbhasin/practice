import java.util.*;

// incomplete
class Subsets {
	public static void main(String args[]) {
		int[] nums = {1,2,3};
		System.out.println(subsets(nums));
	}

	static Set<Set<Integer>> sets;
    public static List<List<Integer>> subsets(int[] nums) {
        set = new HashSet<>();
        helper(nums, new ArrayList<>(), 0);
        for(Set<String> s: sets)
        return result;
    }
    
    public static void helper(int[] nums, List<Integer> curr, int index) {
        if(index>=nums.length) {
        	set.add(new ArrayList<>(curr));
            return;
        }
        helper(nums, curr, index+1, set);
        curr.add(nums[index]);
        helper(nums, curr, index+1, set);
    }
}