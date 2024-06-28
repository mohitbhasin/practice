class FindPeakElement {
	public static void main(String args[]) {
		int[][] numsArr = {
			{1,2,3,1},
			{1,2,1,3,5,6,4},
			{2,1},
			{3,2,3},
		};
		for(int[] nums: numsArr) {
			System.out.println(findPeakElement(nums));
			System.out.println(findPeakElement_reducingWindow(nums));
			System.out.println("--------");
		}
	}

	public static int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        
        int left = 0;
        int right = nums.length-1;
        
        while(left<right) {
            int mid = left + (right-left)/2;
            //if mid reaches 0 or the end, compare nums[0] with next if mid is 0 and compare nums[end] with prev if mid is at the end 
            if(mid==0 || mid==nums.length-1) {
                if(mid==0) return nums[mid]>nums[mid+1] ? mid : mid+1;
                if(mid==nums.length-1) return nums[nums.length-1]>nums[nums.length-2] ? nums.length-1 : nums.length-2;
            }
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
                return mid;
            } else if(nums[mid]<nums[mid+1]) {
                left=mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left]>nums[right] ? left : right;
    }

    public static int findPeakElement_reducingWindow(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<right) {
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[mid+1]) {
                right=mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}