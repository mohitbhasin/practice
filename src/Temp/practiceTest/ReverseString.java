class ReverseString {
	public static void main(String args[]) {
		System.out.println(reverse("abcdefg"));
	}

	public static String reverse(String s) {
		char[] chars = s.toCharArray();

		for(int i=0; i<chars.length/2; i++) {
			char c = chars[i];
			chars[i] = chars[chars.length - 1 - i];
			chars[chars.length - 1 - i] = c;
		}

		return new String(chars);
	}
}