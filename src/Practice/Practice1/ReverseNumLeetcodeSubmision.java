class ReverseNumLeetcodeSubmision {
	public static void main(String args[]) {
		System.out.println(reverse(123));
	}

	public static int reverse(int x) {
        int result = 0;
		int i = 1;
		
		while(x !=0) {
            if(result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10) {
				return 0;
			}
			result = (result * i) + x%10;
			x = x/10;
			i=10;
		}
		
		return result;
    }
}