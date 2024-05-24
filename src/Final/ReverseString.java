class ReverseString {
	public static void main(String args[]) {
		char[] s = {'h','e','l','l','o'};
		reverse(s,0);
		for(char c: s) {
			System.out.print(c+", ");
		}
	}

	public static void reverse(char[] s, int i) {
		if(i>s.length/2) {
			return;
		}
		char c=s[i];
		s[i]=s[s.length-i-1];
		s[s.length-i-1]=c;
		reverse(s,++i);
	}
}