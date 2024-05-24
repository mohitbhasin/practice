class PalindromePermutation {
	public static void main(String args[]) {
		System.out.println(checkPermutation("Tact Coa"));
		// System.out.println(checkPermutation("dad"));
	}

	public static boolean checkPermutation(String s) {
		int count=0;

		for(char c: s.toCharArray()) {
			c = Character.toLowerCase(c);
			if(c - 'a' < 0 || c - 'a' > 'z') continue;
			if((count | (1 << c)) == count) {
				count ^= (1 << c);
			} else {
				count |= (1 << c);
			}
		}
		System.out.println(count);
		int result = 0;

		while(count>0) {
			if((count & 1) > 0) {
				result++;
			}
			count >>>= 1;
		}

		return result<=1;
	}
}