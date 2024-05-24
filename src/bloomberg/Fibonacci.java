import java.util.*;

class Fibonacci {
	static final float LEN_FAC = 0.7f;
	public static void main(String args[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n=5;
		System.out.println(fibo(n, map));
		System.out.println(fib(n, 200));
	}
	
	public static int fibo(int n, Map<Integer, Integer> map) {
		if(map.containsKey(n)) {
			return map.get(n);
		}
		if(n<2) {
			return n;
		}
		if(n==2) {
			return 1;
		}
		int fib = fibo(n-1, map) + fibo(n-2, map);
		map.put(n, fib);
		return fib;
	}

	public static int fib(int n, float len) {
	  System.out.println(len);
	  if(n<2) return n;
	  return fib(n-1, len*LEN_FAC) + fib(n-2,len*LEN_FAC);
	}
}

