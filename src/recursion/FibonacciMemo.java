class FibonacciMemo {
	public static void main(String args[]) {
		// System.out.println(fibMemo(50, new int[51]));

		System.out.println(fib(4));
	}

	public static int fibMemo(int n, int nums[]) {
		if(n<=2) {
			return 1;
		}

		if(nums[n]>2) {
			return nums[n];
		}

		nums[n] = fibMemo(n-1, nums) + fibMemo(n-2, nums);

		return nums[n];
	}


	public static int fib(int n) {
		if(n<=2) {
			return 1;
		}

		return fib(n-1) + fib(n-2);
	}
}