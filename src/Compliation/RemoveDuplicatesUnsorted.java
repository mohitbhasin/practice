import java.util.*;
class RemoveDuplicatesUnsorted {
	public static void main(String args[]) {
		int[] nums = {5,8,1,21,5,15,7,44,15,0,1,21,21,5};
		for(int n: remove(nums)) {
			System.out.print(n+"\t");
		}
	}

	public static int[] remove(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int j=0;
		for(int i=0; i<nums.length-1; i++) {
			if(!set.contains(nums[i])) {
				set.add(nums[i]);
				nums[j++]=nums[i];
			}
		}
		return Arrays.copyOf(nums, set.size());
	}
}