class FibonacciEvenSum {
	public static void main(String args[]) {
		System.out.println(calculate(1000));


	}

	public static int calculate(int n) {
		int[] memo = new int[n+1];
		fib(n, memo);
		int sum=0;
		for(int r: memo) {
			if(r%2==0) {
				sum+=r;
			}
		}
		return sum;
	}

	public static int fib(int n, int[] memo) {
		if(n<2) {
			return 1;
		}
		if(memo[n]>0) {
			return memo[n];
		}
		memo[n] = fib(n-1, memo) + fib(n-2, memo);
		return memo[n];
	}
}