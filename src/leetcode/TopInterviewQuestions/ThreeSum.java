import java.util.*;

class ThreeSum {
	public static void main(String args[]) {
		// int[] nums = {-1,0,1,2,-1,-4};
		int[] nums = {-4,2,2};
		System.out.println(threeSum(nums));


	}

	private static int twoSum(int[] nums, int index, int sum) {
		Map<Integer, Integer> map = new HashMap<>();

		for(int i=index; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				return map.get(nums[i]);
			} else {
				map.put(sum - nums[i], i);
			}
		}
		return -1;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
            	int k = twoSum(nums, j, 0 - nums[i]);
                if(k!=-1) {
                	List<Integer> list = new ArrayList<>();
                	list.add(nums[i]);
                	list.add(nums[j]);
                	list.add(nums[k]);
                	result.add(list);
                }
            }
        }
        return result;
    }
}