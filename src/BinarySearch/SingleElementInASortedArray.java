import java.util.*;

class SingleElementInASortedArray {
	public static void main(String args[]) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[]{1});
		list.add(new int[]{1,1,2,2,3,4,4});
		list.add(new int[]{1,1,2,3,3,4,4});
		list.add(new int[]{1,2,2,3,3,4,4});
		list.add(new int[]{1,1,2,2,3,3,4});


		for(int[] nums: list) {
			System.out.println(singleNonDuplicate(nums));
		}
	}

	public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left<right) {
            int mid = left + (right - left)/2;
            if(mid%2==1) {
                mid--;
            }
            if(nums[mid]==nums[mid+1]) {
                left=mid+2;
            } else {
                right=mid;
            }
        }
        return nums[left];
    }
}