import java.util.*;

class ClosestTime {
	public static void main(String args[]) {
		String time = "23:59";
		permute(new int[]{2,3,5,9});
		permutation("","2359");

	}
    
	// private static void permutation(String prefix, String str) {
	//     int n = str.length();
	//     if (n == 0) System.out.println(prefix);
	//     else {
	//         for (int i = 0; i < n; i++)
	//             permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	//     }
	// }

	public static Set<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        permut(result, nums, new ArrayList<>());

        System.out.println(result.size());
        System.out.println(result);
        return result;

    }

    public static void permut(Set<List<Integer>> result, int[] nums, List<Integer> curr) {
    	if(curr.size()==nums.length) {
    		result.add(new ArrayList<>(curr));
    	} else {
    		for(int num: nums) {
    			curr.add(num);
    			permut(result, nums, curr);
    			curr.remove(curr.size()-1);
    		}
    	}
    }
}