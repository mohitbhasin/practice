class FindFirstLastPosOfElementSortedArray {
	public static void main(String args[]) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		// int[] nums = {2,2};
		// int target = 2;

		int[] result = searchRange(nums, target);
		System.out.println(result[0]+", "+result[1]);
	}


    public static int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums, target, true);
        int r = binarySearch(nums, target, false);
        return new int[]{l, r};
    }
    
    public static int binarySearch(int[] nums, int target, boolean searchLeft) {
        int left = 0;
        int right = nums.length-1;
        int i = -1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid]==target) {
                i = mid;
                if(searchLeft) {
                    right=mid-1;
                } else {
                    left = mid+1;
                }
            } else if(target>nums[mid]) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return i;
    }

    // not recommended - O(logN) + O(n) = O(n)
	public static int[] searchRange_slow(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int a = -1;
        int b = -1;
        while(left<=right) {
            int mid = (right+left) / 2;
            if(nums[mid]==target) {
                a=mid;
                b=mid;
                while(a>left && nums[a-1]==target) {
                	a--;
                }
                while(b<right && nums[b+1]==target) {
                	b++;
                }
                break;
            } else if(nums[mid]<target) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return new int[] {a, b};
    }
}