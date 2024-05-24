import java.util.*;

class FourSum {
	public static void main(String args[]) {
		// 1294967296+1000000000   852516351 + 1294967296 = max
		// 1000000000 - 852516351 = 147483649
		// max = 2147483647
		// min = -2147483648
		List<int[]> numsList = new ArrayList<>();
		// numsList.add(new int[]{1,0,-1,0,-2,2});
		// numsList.add(new int[]{-2,-1,-1,1,1,2,2});
		numsList.add(new int[]{-1000000000,-1000000000,1000000000,-1000000000,-1000000000});
		numsList.add(new int[]{1000000000,1000000000,1000000000,1000000000});
		numsList.add(new int[]{1,-2,-5,-4,-3,3,3,5});
		// numsList.add(new int[]{2,2,2,2,2});
		List<Integer> targets = new ArrayList<>();
		// targets.add(0);
		// targets.add(0);
		targets.add(294967296);
		targets.add(-294967296);
		targets.add(-11);
		// targets.add(8);
		for(int i=0; i<numsList.size(); i++) {
			System.out.println(fourSum(numsList.get(i), targets.get(i)));
		}
	}

    static List<List<Integer>> result;
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        for(int i=0; i<nums.length-3; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length-2; j++) {
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                long sum = nums[i]+nums[j];
                long comp = target - sum;
                twoSum(nums, j+1, comp, i, j);
            }
        }
        return result;
    }
    
    public static void twoSum(int[] nums, int index, long target, int i, int j) {
        int l=index;
        int r=nums.length-1;
        while(l<r) {
            int sum = nums[l]+nums[r];
            if(sum==target) {
                List<Integer> curr = new ArrayList<>();
                curr.add(nums[i]);
                curr.add(nums[j]);
                curr.add(nums[l]);
                curr.add(nums[r]);
                result.add(curr);
                while(l++<r && nums[l]==nums[l-1]);
            } else if(nums[l]+nums[r]>target) {
                r--;
            } else {
                l++;
            }
        }
    }

    public static boolean isOverflowing(int a, int b) {
        System.out.println(a+": "+b);
        if(a>0 && b>0 && (Integer.MAX_VALUE - b)<a) return true;
        if(a<0 && b<0 && (Integer.MAX_VALUE + b)<a) return true;
        return false;
    }
	
}