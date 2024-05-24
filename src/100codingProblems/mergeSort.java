class mergeSort {
	public static void main(String args[]) {
		// int[] nums = new int[] {3,2,7,34,26,2,1,6};
		// int[] nums = {12, 1, 13, 5, 4, 7,0,3,4};
		int[] nums = {5, 3, 8, 2, 7, 4};
		mergeSort(nums, 0, nums.length - 1);
		for(int num: nums) {
			System.out.print(num+" ");
		}
	}

	public static void mergeSort(int[] data, int left, int right) {
		int mid = (left + right) / 2;
		if(left == mid) {
			return;
		} else {
			mergeSort(data,left, mid);
			mergeSort(data,mid,right);
			swap(data, left, right, mid);
		}
	}

	public static void swap(int[] data, int left, int right, int mid) {
		for(int i=0; i<=mid; i++) {
			for(int j=mid+1; j<=right;j++) {
				if(data[i]>data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}
}