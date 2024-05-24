import java.util.*;

class ContainsDuplicateII {
	public static void main(String args[]) {
		int[][] nums = {{1,2,3,1},{1,0,1,1},{1,2,3,1,2,3}};
		int[] ks = {3,1,2};

		for(int i=0; i<nums.length; i++) {
			System.out.println(containsNearbyDuplicate(nums[i], ks[i]));
		}
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], i);
            else {
                if(i - map.get(nums[i])<=k) return true;
                else map.put(nums[i], i);
            }
        }
        return false;
    }
}