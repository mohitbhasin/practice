class FindMinValue {
	public static void main(String args[]) {
		int[] arr = {1,2,3,4,5,6,-7};
		System.out.println(findMin(arr));
		System.out.println(findMin(new int[]{}));

	}

	public static int findMin(int[] arr) {
		if(arr==null || arr.length==0) throw new IllegalArgumentException("Invalid Input provided");
		int min = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i]<min) min=arr[i];
		}
		return min;
	}
}