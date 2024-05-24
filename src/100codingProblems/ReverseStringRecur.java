class ReverseStringRecur {
	public static void main(String args[]) {
		System.out.println(reverseRecur("Mohit"));
	}

	public static String reverseRecur(String s) {
		return reverse(s.toCharArray(), 0);
	}

	public static String reverse(char[] chars, int i) {
		if(i==chars.length/2) {
			return new String(chars);
		}

		char temp = chars[i];
		chars[i] = chars[chars.length - 1 - i];
		chars[chars.length - 1 - i] = temp;

		return reverse(chars, ++i);
	}
}