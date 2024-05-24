class FirstAndLastPos_SortedArray {
	public static void main(String args[]) {
		// int[] nums = {};
		// int[] nums = {2,7,7,7,8,10};
		// int[] nums = {0,0,0,8,10};
		int[] nums = {0,0,0,8,8,8,8};
		for(int n: searchRange(nums, 8)) {
			System.out.print(n + " ");
		}
	}

	public static int[] searchRange(int[] nums, int target) {
        int mid = binarySearch(nums, target, 0, nums.length - 1);
        if(mid==-1) {
            return new int[]{-1,-1};
        }
        int[] result = new int[2];
        int start = binarySearch(nums, target, 0, mid-1);
        if(start==-1) {
        	result[0]=mid;
        } else {
        	result[0]=start;
        }
        int end = binarySearch(nums, target, mid+1, nums.length-1);
        if(end==-1) {
        	result[1]=mid;
        } else {
        	result[1]=end;
        }
        return result;
    }
    
    public static int binarySearch(int[] nums, int target, int start, int end) {
        while(start<=end) {
            int mid = (start + end)/2;
            if(nums[mid]==target) {
                return mid;
            }
            if(nums[mid]>target) {
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return -1;
    }
}