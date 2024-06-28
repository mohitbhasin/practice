import java.util.*;

class LongestConsecutiveSequence {
	public static void main(String args[]) {
		int[] nums = {1,2,0,1};
		System.out.println(longestConsecutive_bruteforce(nums));
		System.out.println(longestConsecutive_bruteforce_improved(nums));
		System.out.println(longestConsecutive(nums));
		System.out.println(longestConsecutive_sort(nums));
		System.out.println(longestConsecutive_sort_similar(nums));
	}

	// Time Complexity O(n^3)
	public static int longestConsecutive_bruteforce(int[] nums) {
		int result = 0;
		for(int num: nums) {
			int currSeq = 1;
			int currVal = num+1;
			while(bruteforce_helper(nums, currVal)) {
				currVal++;
				currSeq++;
			}
			result=Math.max(result, currSeq);
		}
		return result;
	}

	public static boolean bruteforce_helper(int[] nums, int searchVal) {
		for(int num: nums) if(num==searchVal) return true;
		return false;
	}

	// Time Complexity O(n^2)
	public static int longestConsecutive_bruteforce_improved(int[] nums) {
		int result = 0;
		Set<Integer> set = new HashSet<>();
		for(int num: nums) set.add(num);
		for(int num: nums) {
			int currSeq = 1;
			int currVal = num+1;
			while(set.contains(currVal)) {
				currVal++;
				currSeq++;
			}
			result=Math.max(result, currSeq);
		}
		return result;
	}

	//
	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int num: nums) set.add(num);

		int result = 0;
		for(int num: nums) {
			if(!set.contains(num-1)) {
				int curr = num+1;
				int currSeq = 1;
				while(set.contains(curr)) {
					currSeq++;
					curr++;
				}
				result=Math.max(result, currSeq);
			}
		}
		return result;
	}

	// Time Complexity O(nlog n)
    public static int longestConsecutive_sort(int[] nums) {
    	Arrays.sort(nums);
    	int result = 1;
    	int curr = 1;
    	int left=0;
    	for(int right=1; right<nums.length; right++) {
    		if(nums[right]!=nums[right-1]) {
    			if(nums[right]-1==nums[right-1]) {
	    			curr+=1;
	    		} else {
	    			result = Math.max(curr, result);
    				curr=1;
	    		}
    		}
    	}
    	return Math.max(curr, result);
    }
	// Time Complexity O(nlog n)
    public static int longestConsecutive_sort_similar(int[] nums) {
    	Arrays.sort(nums);
    	int result = 1;
    	int curr = 1;
    	int left=0;
    	for(int right=1; right<nums.length; right++) {
    		if(nums[right]==nums[right-1]) continue;
    			if(nums[right]-1==nums[right-1]) {
	    			curr+=1;
	    		} else {
	    			result = Math.max(curr, result);
    				curr=1;
    		}
    	}
    	return Math.max(curr, result);
    }
}