class SampleOperations {
	public static void main(String args[]) {
		// rightShift();
		// leftShift();
		// refer - https://leetcode.com/problems/number-of-1-bits/solution/
		// countOneBits_forPositiveNums();
		// countOneBits_forNegativeNums();
		// for(int i=50; i>0; i--) 
		// System.out.println(i&i-1);


	}

	public static void printLine() {
		System.out.println("-------------");
	}

	// the number can be reduced to 0 if it is assined itself. if the number start with 0, there are not 1 bits to be shifted, it will be infinite loop.
	public static void rightShift() {
		// 8 is represented as 111 in binary;
		// shift right by 1 will give 11, that is 4.
		// below the right shifted number is assigned back to the num.
		int num=8;
		while(num>0) {
			System.out.println(num>>=1);
		}
		printLine();
	}
	// the number will increase with 2 pow n. if the number start with 0, there are no 1 bits to be shifted, it will be infinite loop.
	public static void leftShift() {
		// 1 is represented as 1 in binary;
		// shift left by 1 will give 10, that is 2.
		// below the left shifted number is assigned back to the num.
		int num=1;
		while(num<65) {
			System.out.println(num<<=1);
		}
		printLine();
	}

	// this are naive way of finding number of 1 bits
	// check least significant bit is 1 by using bitwise AND (n&1)==1;
	// then do shift right on the number and assign it back to num ot reduce it;
	// this only works with Positive Numbers, since the number cannot be reduced to 0;
	public static void countOneBits_forPositiveNums() {
		int n = 7;
		int count1s = 0;
		while(n!=0) {
			if((n&1)==1) count1s++;
			n>>=1;
		}
		System.out.println(count1s);
		printLine();
	}
	// this is naive way of finding number of 1 bits
	// Since there are only 32 bits, instead of reducing or increase number, the 1 bits can be counted 32 times
	public static void countOneBits_forNegativeNums() {
		int n = -4;
		int count1s = 0;
		for(int i=0; i<32; i++) {
			if((n&1)==1) count1s++;
			n>>=1;
		}
		System.out.println(count1s);
		printLine();
	}
}