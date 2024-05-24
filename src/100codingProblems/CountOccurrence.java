class CountOccurrence {
	public static void main(String args[]) {
		System.out.println(count("sadjasdka", 'a'));
	}

	public static int count(String s, char c) {
		int result = 0;

		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==c) {
				result++;
			}
		}

		return result;
	}
}