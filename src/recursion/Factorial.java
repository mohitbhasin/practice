package recursion;

public class Factorial {
	public static void main(String args[]) {
		int num = 5;
		System.out.println("Factorial of "+num+" --> "+fact(num));
	}
	
	// fact of 5 = 5*4*3*2*1
	//or fact of 5 = 5*fact of 4
	static int fact(int num) {
		if(num<2) {
			return num;
		} else {
			return num*fact(num-1);
		}
	}
}
