class ReverseWordsInSentence {
	public static void main(String args[]) {
		System.out.println(reverseSentence("You can buy beets at apple store"));

	}

	public static String reverseSentence(String s) {
		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String word : words) {
			sb.append(reverseWord(word));
			sb.append(" ");
		}

		return sb.toString();
	}

	public static String reverseWord(String word) {
		char[] chars = word.toCharArray();

		for(int i=0; i<chars.length/2; i++) {
			char temp = chars[i];
			chars[i] = chars[chars.length - 1 - i];
			chars[chars.length - 1 - i] = temp;
		}

		return new String(chars);
	}
}