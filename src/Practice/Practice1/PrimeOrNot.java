class PrimeOrNot {
	public static void main(String args[]) {
		System.out.println(primeCheck(68));

	}


	public static boolean primeCheck(int num) {
		if(num<2) {
			return false;
		} else if(num==2 || num==3) {
			return true;
		} else if (num%2==0){
			return false;
		}
		return true;
	}
}