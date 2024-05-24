class MergeSortedArray {
	public static void main(String args[]) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		merge(nums1, 3, nums2, 3);
		for(int num: nums1) {
			System.out.print(num+", ");
		}
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m-1;
        int y = n-1;
        int index = nums1.length-1;

        while(x>=0 || y>=0) {
            if(x>=0 && y>=0) {
                nums1[index] = nums1[x] > nums2[y] ? nums1[x--] : nums2[y--];
            } else if(x>=0) {
                nums1[index] = nums1[x];
                x--;
            } else {
                nums1[index] = nums2[y];
                y--;
            }
            index--;
        }
    }
}