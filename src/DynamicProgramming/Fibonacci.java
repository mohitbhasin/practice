import java.util.*;
// 0, 1, 1, 2, 3, 5
class Fibonacci {
	static Map<Integer, Integer> map = new HashMap<>();
	public static void main(String args[]) {
		memo = new int[71];
		System.out.println(fib(70));
		System.out.println(fibo(70));
		System.out.println(fibMemoRecurr(70));
	}


	public static int fibo(int n) {
		int[] arr = {0, 1};
		if(n<2) return n;
		int result=0;
		for(int i=2; i<=n; i++) {
			result = arr[0] + arr[1];
			arr[0] = arr[1];
			arr[1] = result;
		}

		return result;
	}

	public static int fib(int n) {
		if(n<2) {
			return n;
		}

		if(n==2) {
			return 1;
		}

		if(map.containsKey(n)) {
			return map.get(n);
		}
		int result = fib(n-1) + fib(n-2);
		map.put(n, result);
		return result;
	}

	static int[] memo;
	public static int fibMemoRecurr(int n) {
		if(n<2) return n;
		if(memo[n]>0) return memo[n];
		memo[n] = fibMemoRecurr(n-1) + fibMemoRecurr(n-2);
		return memo[n];
	}

	
}