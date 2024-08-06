class GreatestCommonDivisor {
	public static void main(String args[]) {
		System.out.println(gcd_bruteforce(6,9));
		System.out.println(gcd_bruteforce(32, 20));
		System.out.println(gcd_bruteforce(98, 70));
		System.out.println(gcd_bruteforce(399, 437));
		System.out.println();
		System.out.println(gcd_Euclid_inline(6,9));
		System.out.println(gcd_Euclid_inline(32, 20));
		System.out.println(gcd_Euclid_inline(98, 70));
		System.out.println(gcd_Euclid_inline(399, 437));
		System.out.println();
		System.out.println(gcd_Euclid(6,9));
		System.out.println(gcd_Euclid(32, 20));
		System.out.println(gcd_Euclid(98, 70));
		System.out.println(gcd_Euclid(399, 437));
    }

    public static int gcd_bruteforce(int a, int b) {
    	if(a>b) return gcd_bruteforce(b, a);
    	int divisor = a;

    	while(divisor>0) {
    		if(a%divisor==0 && b%divisor==0) return divisor;
    		divisor--;
    	}
    	return 1;
    }

    public static int gcd_Euclid_inline(int a, int b) {
    	if(a==0) return b;
    	return gcd_Euclid_inline(b%a, a);
    }

    public static int gcd_Euclid(int x, int y) {
    	// Euclidian Algorithm 
    	// x = y * q + r
    	// x = (y * (x/y)) + (x%y)
        int q = x/y; // q is not required
        int r = x%y;
        System.out.println(x + " = "+y+" . "+q+" + "+r);
        if(r==0) return y;
        else return gcd_Euclid(y, r);
    }

}