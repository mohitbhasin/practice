class FindMissingNumber {
	public static void main(String args[]) {
		int[] arr = {5,8,2,4,6,3,9,7};
		System.out.println(findNum(arr, 9));
	}

	public static int findNum(int[] arr, int n) {
		int total = n*(n+1)/2;
		int sum = 0;
		for(int val: arr) sum+=val;
		return total-sum;
	}
}