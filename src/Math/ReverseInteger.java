class ReverseInteger {
	public static void main(String args[]) {
		int x = -123;
		// int x = 1534236469;
		System.out.println(reverse(x));
	}

	public static int reverse(int x) {
        int sign = x<0 ? -1 : 1;
        x*=sign;
        int result = 0;
        
        while(x>0) {
            if(result>Integer.MAX_VALUE/10) return 0;
            result=result*10 + x%10;
            x/=10;
        }
        
        result*=sign;
        return result;
    }
}