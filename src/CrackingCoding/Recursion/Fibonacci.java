class Fibonacci {
	public static void main(String args[]) {
		System.out.println(fibo(7));
		System.out.println(fibIterative(7));
	}

	public static int fibo(int n) {
		if(n<3) {
			return 1;
		}

		return fibo(n-1)+fibo(n-2);
	}

	public static int fibIterative(int n) {
		if(n<=0) {
			return -1;
		}

		else if(n<3) {
			return 1;
		}

		int a=1;
		int b=1;
		for(int i=3; i<=n; i++) {
			int c=a+b;
			a=b;
			b=c;
		}
		return b;
	}
}