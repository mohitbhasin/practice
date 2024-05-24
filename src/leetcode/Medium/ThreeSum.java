import java.util.*;

class ThreeSum {
	public static void main(String args[]) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
		// int[] nums = {-1,0,1,2,-1,-4};
        // int[] nums = {-2,0,0,2,2};
		// int[] nums = {-2,0,0,2,2};
		System.out.println(threeSum(nums));
        System.out.println(threeSum2(nums));
        System.out.println(threeSum3(nums));
	}

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // Found a triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Move the pointers
                    j++;
                    k--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> triplet;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length - 1;
            while(left<right) {
                int sum = nums[left] + nums[right];
                if(sum==-nums[i]) {
                    triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left++]);
                    triplet.add(nums[right--]);
                    result.add(triplet);
                    while(left<right && nums[left]==nums[left-1]) {
                        left++;
                    }
                } else if(sum>-nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr;

        for(int i=0; i<nums.length-2; i++) {
        	if(i>0 && nums[i]==nums[i-1]) continue;

        	int left=i+1, right=nums.length-1;

        	while(left<right) {
        		int sum = nums[i]+nums[left]+nums[right];
        		if(sum==0) {
        			curr = new ArrayList<>();
        			curr.add(nums[i]);
        			curr.add(nums[left]);
        			curr.add(nums[right]);
        			result.add(curr);
        			left++;
        			right--;
        			while(left<right && nums[left]==nums[left-1]) {
        				left++;
        			}
        		}
        		else if(sum>0) {
        			right--;
        		} else {
        			left++;
        		}
        	}
        }
        return result;
    }

}