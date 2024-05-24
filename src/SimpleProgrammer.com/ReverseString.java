class ReverseString {
	public static void main(String args[]) {

		String s = "planetoftheapes";
		System.out.println(reverse(s.toCharArray(), 0));
	}

	public static String reverse(char[] s, int i) {
		if(i>s.length/2) {
			return new String(s);
		}
		char c = s[i];
		s[i] = s[s.length - i - 1];
		s[s.length - 1 - i] = c;

		return reverse(s, i+1);
	}
}