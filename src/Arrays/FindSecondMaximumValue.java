class FindSecondMaximumValue {
	public static void main(String args[]) {
		int[] arr = {11,10,2,10,4,5,6,7};
		System.out.println(findSecondMax(arr));
	}

	public static int findSecondMax(int[] arr) {
		if(arr.length==0) throw new IllegalArgumentException();
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				secondMax=max;
				max=arr[i];
			}
			// arr[i]!=a is used to if there are duplicate values for max
			else if(arr[i]>secondMax && arr[i]!=max) {
				secondMax=arr[i];
			}
		}
		return secondMax;
	}
}