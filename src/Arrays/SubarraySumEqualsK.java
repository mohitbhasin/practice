import java.util.*;

class SubarraySumEqualsK {
	public static void main(String args[]) {
		// int[] nums = {1,1,1};
		// int k = 2;
		// int[] nums = {1,-2,12,6,5,4,3,-4,2,4};
		// int k = 8;
		// int[] nums = {1,-1,0};
		// int k = 0;
		// int[] nums = {3,4,7,2,-3,1,4,2};
		// int k = 7;
		int[] nums = {7,-7,7,-7};
		int k = 0;
		System.out.println(subarraySumLinear(nums, k));
		// System.out.println(subarraySum(nums, k));
	}

	public static int subarraySumLinear(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count=0;
		int sum=0;
		for(int num: nums) {
			sum+=num;
			if(map.containsKey(sum-k)) {
				count+=map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			System.out.println("Sum: "+sum+" "+map);
		}

		return count;
    }

	// O(n2)
	public static int subarraySum(int[] nums, int k) {
        int count=0;

        for(int i=0; i<nums.length; i++) {
            int temp=0;
            for(int j=i; j<nums.length; j++) {
                temp+=nums[j];
                if(temp==k) count++;
            }
        }
        return count;
    }
}