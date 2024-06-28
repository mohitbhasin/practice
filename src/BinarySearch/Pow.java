class Pow {
	public static void main(String args[]) {
		System.out.println(pow(2, 10));
		System.out.println(pow(2, -1));
		System.out.println(pow(1, (long) -2147483648));
		System.out.println(pow(2, (long) -2147483648));
		System.out.println(pow(2, -2));
	}
	// changing n to long to accomodate min value -2147483648, 
	// which when changed to +ve in recursive call will over flow 
	// as the max value for int is 2147483647.
	public static double pow(double x, long n) {
		if(n==0) return 1;
		if(n<0) return 1/pow(x, -n);
		if(n%2==1) return x * pow(x * x, (n-1)/2);
		else return pow(x*x, n/2);
	}

	//Not recommended. Brute force. Time Complexity: linear O(n).
	public static double pow_linear(double x, int n) {
		if(n==0) return 1;
		if(n<0) return 1/pow(x, -n);
		return x*pow(x, n-1);
	}
}