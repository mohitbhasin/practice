class MergeSort {
	public static void main(String args[]) {
		int[] arr = {5, 3, 8, 2, 7, 4};
		mergeSort(arr, 0, arr.length-1);
		for(int i: arr) {
			System.out.print(i+"\t");
		}
	}

	public static void mergeSort(int[] arr, int left, int right) {
		int mid=(left+right)/2;
		if(left==mid) {
			return;
		}
		mergeSort(arr, left, mid);
		mergeSort(arr, mid, right);
		sort(arr, left, mid, right);
	}

	public static void sort(int[] arr, int left, int mid, int right) {
		for(int i=left; i<=mid; i++) {
			for(int j=mid; j<=right; j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
}