import java.util.*;

class ThreeSum {
	public static void main(String args[]) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0) return result;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(i==0 || nums[i]!=nums[i-1]) {
                twoSum(nums, i+1, -nums[i], result);
            }
        }
        
        return result;
    }
    
    public static void twoSum(int[] nums, int index, int target, List<List<Integer>> result) {
        int left = index;
        int right = nums.length-1;
        
        while(left<right) {
            int sum = nums[left]+nums[right];
            if(sum==target) {
                result.add(Arrays.asList(-target, nums[left], nums[right]));
                while(left<right && nums[left]==nums[left+1]) left++;
            }
            if(sum>target) {
                right--;
            } else {
                left++;
            }
        }
    }
}