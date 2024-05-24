class ReverseBits {
	public static void main(String args[]) {
		// int n=4;
		int n=43261596;
		// expected output = 964176192
		printBits(n);
		System.out.println();
		System.out.println(reverseBits(n));
		

	}

	public static void printBits(int n) {
		for(int i=0; i<32; i++) {
			System.out.print(n>>1 & 1);
			n>>=1;
		}
	}

	public static int reverseBits(int n) {
        int result = 0;
        int count=32;
        while(count-->0) {
            result<<=1;
            result+=n & 1;
            n>>=1;
        }
        return result;
    }
}