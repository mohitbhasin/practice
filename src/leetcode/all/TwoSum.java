package leetcode.all;

import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		
		for(int i : findTwoSum(nums, target)) {
			System.out.println("val - "+i);
		}

	}
	
	public static int[] findTwoSum(int[] nums,int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length-1;i++) {
			int remainder = target - nums[i];
			if(map.containsKey(remainder)) {
				return new int[] {i,map.get(remainder)};
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException();
	}
}
