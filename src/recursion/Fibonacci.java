package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	static Map<Integer,Integer> data = new HashMap<>();
	
	public static void main(String args[]) {
		int num = 5;
		System.out.println("Fibonacci of "+num+" --> "+fib(num));
		System.out.println("---------------");
		System.out.println("Fibonacci Memo of "+num+" --> "+fibMemo(num));
	}
	
	//fibonacci series	0 1 1 2 3 5 8 13 21
	//nums				0 1 2 3 4 5 6  7  8
	
	//this is through recursion only
	static int fib(int num) {
		if(num<2) {
			return num;
		}else {
			System.out.println("calculating for "+num);
			return fib(num-1) + fib(num-2);
		}
	}
	
	//this can me improved by not processing already calculated num 
	//	with the technique called Memoization
	static int fibMemo(int num) {
		if(num<2) {
			return num;
		}
		if(data.containsKey(num)) {
			return data.get(num);
		}
		
		System.out.println("calculating for "+num);
		int result = fib(num-1) + fib(num-2); 
		data.put(num, result);
		return result;
		
	}
}
