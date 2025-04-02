public class PrimeOrNot {
	public static void main(String args[]){
		int nums[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
		for(int a: nums) {
			System.out.println("is "+a+" prime= "+isPrime(a));
		}
	}
	
	static boolean isPrime(int num) {
		if(num <=1) {
			return false;
		}
		for(int i=2;i<num/2; i++) {
			if(num%i==0) {
				
				return false;
			}
		}
		return true;
	}
}
