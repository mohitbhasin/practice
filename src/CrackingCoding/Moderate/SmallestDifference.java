class SmallestDifference {
	public static void main(String args[]) {
		int[] arr1 = {1,3,15,11,2};
		int[] arr2 = {23,127,253,19,8};
		System.out.println(diff(arr1,arr2));
	}

	public static int diff(int[] arr1, int[] arr2) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				int temp = Math.abs(arr1[i]-arr2[j]);
				if(temp<min) {
					min=temp;
				}
			}
		}
		return min;
	}
}