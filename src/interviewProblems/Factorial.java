package interviewProblems;

public class Factorial {
	public static void main(String args[]) {
		
		int num = 9;
//		System.out.println(fact(num));
		System.out.println(fib(num));
		
	}
	
	public static int fact(int num) {
		System.out.println("recursion with num = " +num);
		if(num <= 1) {
			return 1;
		} else {
			return fact(num-1) * num;
		}
	}
	
	public static int fib(int num) {
		System.out.println("recursion with num = " +num);
		if(num <= 2) {
			return 1;
		} else {
			return fib(num-1) + fib(num-2);
		}
	}
}
