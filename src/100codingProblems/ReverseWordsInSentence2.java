class ReverseWordsInSentence2 {
	public static void main(String args[]) {
		String s = "Organic Kale Chpis";
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String word: words) {
			sb.append(reverse(word));
			sb.append(" ");
		}
		return sb.toString();
	}

	public static String reverse(String s) {
		char[] chars = s.toCharArray();
		for(int i=0; i<chars.length/2; i++) {
			char temp = chars[i];
			chars[i] = chars[chars.length - i -1];
			chars[chars.length - i -1] = temp;
		}
		return new String(chars);
	}
}