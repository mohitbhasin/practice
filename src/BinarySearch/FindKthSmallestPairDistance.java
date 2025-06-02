import java.util.*;

class FindKthSmallestPairDistance {
	public static void main(String args[]) {
		List<int[]> numsList = new ArrayList<>();
		List<Integer> kList = new ArrayList<>();
		numsList.add(new int[]{1,2,3});
		kList.add(1);
		numsList.add(new int[]{800, 200, 500, 900});
		kList.add(5);
		numsList.add(new int[]{7, 5, 3, 11, 2});
		kList.add(6);
		numsList.add(new int[]{1,3,2,7,10});
		kList.add(5);
		numsList.add(new int[]{1000,1});
		kList.add(1);
		numsList.add(new int[]{4,8,6,2});
		kList.add(5);
		for(int i=0; i<numsList.size(); i++){
			System.out.println(smallestDistancePair(numsList.get(i), kList.get(i)));
			// System.out.println(smallestDistancePair_binarysearch(numsList.get(i), kList.get(i)));
			// System.out.println(smallestDistancePair_bruteforce(numsList.get(i), kList.get(i)));
			System.out.println("---------");
		}
	}

	// This is a preferred approach. The second binary serach approach is a bit confusing.
	// Time Complexity - O(NLogN+NLogW). Space Complexity - O(N)
	public static int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);

		int left = 0;
		int right = nums[nums.length - 1] - nums[0];

		while(left<right) {
			int mid = left + (right-left)/2;
			int result = countDiff(nums, mid, k);
			if(result<k) {
				left=mid+1;
			} else {
				right=mid;
			}
		}
		return left;
	}
	// find all diff of pairs having value less than mid 
	public static int countDiff(int[] nums, int mid, int k) {
	    int count = 0;
	    int left = 0;
	    int right = 1;
	    while(right<nums.length) {
	    	if(nums[right]-nums[left]<=mid) {
	    		count+=right-left;
	    		right++;
	    	} else {
	    		left++;
	    	}
	    }
	    return count;
	}

	public static int smallestDistancePair_binarysearch(int[] nums, int k) {
		Arrays.sort(nums);

		int left = 0;
		int right = nums[nums.length - 1] - nums[0];

		while(left<right) {
			int mid = left + (right-left)/2;
			if(valid_binary(nums, mid, k)) {
				right = mid;
			} else {
				left=mid+1;
			}
		}
		return left;
	}

	public static boolean valid_binary(int[] nums, int value, int k) {
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

	// Bruteforce approach. Time Limit Exceeds
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