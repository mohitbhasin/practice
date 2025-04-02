public class ReverseNumber {

	public static void main(String args[]) {
		System.out.println(reverseNumber(234));
	}
	
	public static int reverseNumber(int num) {
		int result = 0;
		int i = 1;
		
		while(num !=0) {
			result = (result * i) + num%10;
			num = num/10;
			i=10;
		}
		
		return result;
	}
}