class NumberOfOneBits {
	public static void main(String args[]) {
		int n = 11111111111111111111111;
		System.out.println(hammingWeight(n));
	}

	public static int hammingWeight(int n) {
        int count=0;
        while(n>0) {
        	System.out.println(n);
        	int val = n>>1;
            if(val>0) {
                count++;
            }
            n/=10;
        }
        return count;
    }
}