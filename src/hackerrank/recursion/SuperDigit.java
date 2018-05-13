package hackerrank.recursion;

public class SuperDigit {
	public static void main(String args[]) {
		
//		System.out.println("Digit sum of 12 with K=4 is "+ digitSum("148", 3));
//		String a = "12";
		System.out.println("Digit Sum for 148="+digitSum("148",3));
	}
	
	
	static int digitSum(String n, int k) {
		if(n.length()<=1) {
			return Integer.parseInt(n)*k;
		}
		int num =(n.charAt(0) - '0')*k;
		System.out.println("N="+n+" K="+k+"num="+num);
		int sum = num + digitSum(n.substring(1),k);
		if(sum>9) {
			return digitSum(Integer.toString(sum),1);
		}
		return sum;
		
	}
}
