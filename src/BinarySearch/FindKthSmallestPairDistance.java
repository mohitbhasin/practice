import java.util.*;

class FindKthSmallestPairDistance {
	public static void main(String args[]) {
		// int[] nums = {2,2,0,1,1,0,0,1,2,0};
		// int k = 2;
		// int[] nums = {9,10,7,10,6,1,5,4,9,8};
		// int k = 18;
		int[] nums = {1,3,2,7,10};
		int k = 5;
		System.out.println(smallestDistancePair_bruteforce(nums, k));
		System.out.println(smallestDistancePair_binarysearch(nums, k));
	}


	public static int smallestDistancePair_binarysearch(int[] nums, int k) {
		Arrays.sort(nums);

		int left = 0;
		int right = nums[nums.length - 1] - nums[0];

		while(left<right) {
			int mid = left + (right-left)/2;
			if(valid(nums, mid, k)) {
				right = mid;
			} else {
				left=mid+1;
			}
		}
		return left;
	}

	public static boolean valid(int[] nums, int value, int k) {
		int left = 0;
	    int count = 0;
	    int prev = nums[left];
	    for(int right=1; right<nums.length; right++) {
	    	while(nums[right]-nums[left] > value) {
	    		left++;
	    	}
	    	count+=right-left;
	    }
	    return count>=k;
	}

	// Time Limit Exceeds
	public static int smallestDistancePair_bruteforce(int[] nums, int k) {
		Map<Integer, Integer> map = new TreeMap<>();
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				int diff = Math.abs(nums[j]-nums[i]);
				map.put(diff, map.getOrDefault(diff, 0)+1);
			}
		}
		for(int key: map.keySet()) {
			k-=map.get(key);
			if(k<=0) return key;
		}
		return -1;
	}
}