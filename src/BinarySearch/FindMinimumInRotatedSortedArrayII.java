class FindMinimumInRotatedSortedArrayII {
	public static void main(String args[]) {
		int[][] numsArr = {
			// {2,2,2,0,1},
			{1,1,0,1,1,1,1}
		};

		for(int[] nums: numsArr) {
			System.out.println(findMin(nums));
		}
	}
	// template 2 inspired
	public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left<right) {
        	int mid = left + (right-left)/2;
        	if(nums[mid]>nums[right]) {
        		left=mid+1;
        	} else if(nums[mid]<nums[left]) {
        		right=mid;
        	}
        	else {
        		right--;
        	}
        }
        return nums[left];
    }
}