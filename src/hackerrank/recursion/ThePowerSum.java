package hackerrank.recursion;

public class ThePowerSum {
	public static void main(String args[]) {
		int num = 10;
		System.out.println("power sume for " + num + "---> " + powerSum(100, 1, 2));
	}
	
	//10 --> 2
	// coz there are 2 solutions 
	//1. 
	//2. 1 sq + 3 sq i.e 1+9 = 10
	//solution online
	static int powerSum(double num, int n, int pow) {
		double result = Math.pow(n, pow);
		if(num == result) {
			System.out.println("n---> "+ n + " Result["+result+"] = Num["+num+"]");
			return 1;
		} 
		if (result>num) {
			return 0;
		}
		else {
			return powerSum(num, n+1, pow) + powerSum(num-result, n+1, pow);
		}
//		if (result < num) {
//			System.out.println("n---> "+ n + " Result["+result+"] < Num["+num+"]");
//			return powerSum(num, n+1, pow) + powerSum(num-result, n+1, pow);
//		}	
//		else {
//			System.out.println("n---> "+ n + " Result["+result+"] > Num["+num+"]");
//			return 0;
//		}
	}	
}
