class GreatestCommonDivisor {
	public static void main(String args[]) {
		System.out.println(gcd_BF(6,9));
		System.out.println(gcd_BF(32, 20));
		System.out.println(gcd_BF(98, 70));
		System.out.println(gcd_BF(399, 437));
		System.out.println();
		System.out.println(gcd_Euclid(6,9));
		System.out.println(gcd_Euclid(32, 20));
		System.out.println(gcd_Euclid(98, 70));
		System.out.println(gcd_Euclid(399, 437));
    }

    public static int gcd_BF(int a, int b) {
    	if(a>b) return gcd_BF(b, a);
    	int divisor = a;

    	while(divisor>0) {
    		if(a%divisor==0 && b%divisor==0) return divisor;
    		divisor--;
    	}
    	return 1;
    }

    public static int gcd_Euclid(int a, int b) {
    	if(a==0) return b;
    	return gcd_Euclid(b%a, a);
    }

}