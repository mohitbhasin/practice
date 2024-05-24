import java.util.*;

class Permutations {
    public static void main(String args[]) {
        int[] nums = {1,2,3};
        System.out.println(permute_better(nums));
        // System.out.println(permute_slowest(nums));
        // System.out.println(permute_okay(nums));
    }

    public static List<List<Integer>> permute_better(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        result = new ArrayList<>();
        for(int num: nums) curr.add(num);
        helper(nums, 0, curr);
        return result;
    }
    
    public static void helper(int[] nums, int index, List<Integer> curr) {
        System.out.println(curr);
        if(index==nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
       
        for(int i=index; i<nums.length; i++) {
            Collections.swap(curr, i, index);
            helper(nums, index+1, curr);
            Collections.swap(curr, i, index);
        }
    }

    static List<List<Integer>> result;
    public static List<List<Integer>> permute_slowest(int[] nums) {
        result=new ArrayList<>();
        if(nums.length==0) return result;
        helper2(new ArrayList<>(), nums);
        return result;
    }
    
    public static void helper2(List<Integer> curr, int[] nums) {
        if(curr.size()==nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int n: nums) {
            if(!curr.contains(n)) {
                curr.add(n);
                helper2(curr, nums);
                curr.remove(curr.size()-1);
            }
        }
    }

    // time compplexity: The helper function uses backtracking to find all permutations of the input array nums. 
    // The time complexity of the function is O(n!), where n is the length of the input array. 
    // This is because for each position in the resulting permutation, there are n choices of elements to place. 
    // Therefore, the total number of permutations is n * (n-1) * (n-2) * ... * 2 * 1, which is factorial of n. 
    // The space complexity of the function is also O(n!), because in the worst case, 
    // the resulting list 'result' will contain n! permutations of nums. 
    // Additionally, the function uses additional space for the current permutation 'curr' and 
    // the set 'set' to keep track of used elements. Overall, the function has a time and space complexity of O(n!).
    public static List<List<Integer>> permute_okay(int[] nums) {
        result = new ArrayList<>();
        helper(nums, new ArrayList<>(), new HashSet<>());
        return result;
    }
    
    public static void helper(int[] nums, List<Integer> curr, Set<Integer> set) {
        // System.out.println(curr);
        if(curr.size()==nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!set.contains(i)) {
                curr.add(nums[i]);
                set.add(i);
                helper(nums, curr, set);
                curr.remove(curr.size()-1);
                set.remove(i);
            }
        }
    }
}