package recursion;

public class Fibonacci {
	public static void main(String args[]) {
		int num = 8;
		System.out.println("Fibonacci of "+num+" --> "+fib(num));
	}
	
	//fibonacci series	0 1 1 2 3 5 8 13 21
	//nums				0 1 2 3 4 5 6  7  8
	static int fib(int num) {
		if(num<2) {
			return num;
		}else {
			return fib(num-1) + fib(num-2);
		}
	}
}
