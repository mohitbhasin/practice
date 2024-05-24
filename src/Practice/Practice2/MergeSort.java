class MergeSort {
	public static void main(String args[]) {
		int[] arr = {8,2,-1,6,18,5};
		merge(arr, 0, arr.length-1);
		for(int i: arr) {
			System.out.print(i+"\t");
		}
	}

	public static void merge(int[] arr, int left, int right) {
		int mid = (left+right)/2;
		if(left==mid) {
			return;
		}

		merge(arr, left, mid);
		merge(arr, mid+1, right);
		sort(arr, left, right, mid);
	}

	public static void sort(int[] arr, int left, int right, int mid) {
		for(int i=left; i<=mid; i++) {
			for(int j=mid+1; j<=right; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}