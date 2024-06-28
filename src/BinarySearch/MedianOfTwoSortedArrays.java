class MedianOfTwoSortedArrays {
	public static void main(String args[]) {
		// int[] nums1 = {1,3};
		// int[] nums2 = {2};
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int n = nums1.length;
        int m = nums2.length;
        
        int total = n+m;
        int half = total/2;
        
        int left = 0;
        int right = nums1.length-1;
        
        while(true) {
        	// floor division for -1/2 returns 0, while simple -1/2 return -1;
            int AMid = Math.floorDiv(left + right, 2);
            int BMid = half-AMid-2;
            double ALeft = AMid>=0 ? nums1[AMid] : Integer.MIN_VALUE;
            double ARight = AMid+1<nums1.length ? nums1[AMid+1] : Integer.MAX_VALUE;
            double BLeft = BMid>=0 ? nums2[BMid] : Integer.MIN_VALUE;
            double BRight = BMid+1<nums2.length ? nums2[BMid+1] : Integer.MAX_VALUE;
            if(ALeft<=BRight && BLeft<=ARight) {
                if(total%2==0) {
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight))/2;
                } else {
                    return Math.min(ARight, BRight);
                }
            } else if(ALeft>BRight) {
                right=AMid-1;
            } else {
                left=AMid+1;
            }
        }
    }
}