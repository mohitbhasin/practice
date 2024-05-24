class Recurr2 {
	public static void main(String args[]) {
		char[] s = new char[] {'h','e','l','l','o'};
		for(char c: reverseString(s, 0)) {
			System.out.print(c);
		}
		System.out.println("");
		char[] s2 = new char[] {'h','e','l','l','o'};
		for(char c: reverseStringIterative(s2)) {
			System.out.print(c);
		}
	}

	public static char[] reverseString(char[] s, int i) {
		if(i==s.length/2) {
			return s;
		}
		int tempIndex = (s.length - 1) - i;
		char c=s[i];
		s[i] = s[tempIndex];
		s[tempIndex] = c;
		return reverseString(s, i+1);
	}

	public static char[] reverseStringIterative(char[] s) {
		for(int i=0; i<s.length/2; i++) {
			int index = (s.length - 1) - i;
			char c=s[i];
			s[i]=s[index];
			s[index]=c;
		}
		return s;
	}
}