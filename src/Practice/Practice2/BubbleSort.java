class BubbleSort {
	public static void main(String args[]) {
		// int[] arr = {9,8,7,6,5,4,3,2,1,0};
		int[] arr = {8,2,-1,6,18,5};
		sort(arr);
		for(int i: arr) {
			System.out.print(i+"\t");
		}
	}

	public static void sort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
}